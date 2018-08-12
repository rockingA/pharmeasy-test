package com.pharmeasy.test.service.impl;

import com.pharmeasy.test.entity.ACCESS;
import com.pharmeasy.test.entity.Prescription;
import com.pharmeasy.test.entity.PrescriptionAccess;
import com.pharmeasy.test.entity.Subject;
import com.pharmeasy.test.exception.*;
import com.pharmeasy.test.model.dto.AccessActionDTO;
import com.pharmeasy.test.repository.PrescriptionAccessRepository;
import com.pharmeasy.test.repository.PrescriptionRepository;
import com.pharmeasy.test.service.PrescriptionAccessService;
import com.pharmeasy.test.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionAccessServiceImpl implements PrescriptionAccessService {

    @Autowired
    PrescriptionAccessRepository prescriptionAccessRepository;

    @Autowired
    SubjectService subjectService;


    @Autowired
    PrescriptionRepository prescriptionRepository;


    @Override
    @Transactional
    public PrescriptionAccess requestPrescriptionAccess(Long prescriptionId, Long from, Long to) {

        Subject subjectFrom = subjectService.getSubjectById(from);
        Subject subjectTo = subjectService.getSubjectById(to);

        Prescription prescription = null;
        for (Prescription prescription1: subjectTo.getPrescriptions()) {
            if(prescription1.getId().equals(prescriptionId)){
                prescription = prescription1;
            }
        }

        if(prescription == null){
            throw new PrescriptionNotFoundException();
        }
        PrescriptionAccess prescriptionAccessExisting = prescriptionAccessRepository.findFirstByFromExtraAndToExtraAndPrescriptionId(from,to,prescriptionId);
        if (prescriptionAccessExisting != null){
            throw new PrescriptionAccessAlreadyRequestException();
        }

        prescriptionAccessExisting = new PrescriptionAccess(subjectFrom,from,subjectTo,to,prescriptionId);

       return prescriptionAccessRepository.save(prescriptionAccessExisting);
    }

    @Override
    @Transactional
    public Boolean hasAccess(Long prescriptionId, Long from, Long to) {

        Subject subjectFrom = subjectService.getSubjectById(from);
        Subject subjectTo = subjectService.getSubjectById(to);

        Prescription prescription = null;
        for (Prescription prescription1: subjectTo.getPrescriptions()) {
            if(prescription.getId().equals(prescriptionId)){
                prescription = prescription1;
            }
        }

        if(prescription == null){
            throw new PrescriptionNotFoundException();
        }

        PrescriptionAccess prescriptionAccessExisting = prescriptionAccessRepository.findFirstByFromExtraAndToExtraAndPrescriptionId(from,to,prescriptionId);

        if(prescriptionAccessExisting.getAccess().equals(ACCESS.APPROVED))
        {
            return true;
        }

        return false;
    }

    @Override
    public PrescriptionAccess getById(Long id) {

        Optional<PrescriptionAccess> optionalPrescriptionAccess = prescriptionAccessRepository.findById(id);
        if(optionalPrescriptionAccess.isPresent()){
            return optionalPrescriptionAccess.get();
        }

        throw new PrescriptionNotFoundException();
    }

    @Override
    public List<PrescriptionAccess> getAllPendingSubscription(Long subjectId) {

        //this internally does subject validation
        Subject subject = subjectService.getSubjectById(subjectId);

        return prescriptionAccessRepository.findAllByToExtraAndAccess(subjectId,ACCESS.PENDING);
    }

    @Override
    @Transactional
    public PrescriptionAccess doAction(Long subjectId, AccessActionDTO accessActionDTO) {
        //this internally does subject validation
        Subject subject = subjectService.getSubjectById(subjectId);

        //this internally does prescription validation
        PrescriptionAccess prescriptionAccess = getById(accessActionDTO.getAccessId());

        if(!prescriptionAccess.getToExtra().equals(subjectId)){
            throw new PrescriptionAccessNotYoursException();
        }

        prescriptionAccess.setAccess(accessActionDTO.getAccess());
        return prescriptionAccessRepository.save(prescriptionAccess);
    }

    @Override
    public Prescription getPrescription(Long from, Long to, Long prescriptionId) {
        PrescriptionAccess prescriptionAccessExisting = prescriptionAccessRepository.findFirstByFromExtraAndToExtraAndPrescriptionId(from,to,prescriptionId);

        if(prescriptionAccessExisting == null){
            throw new PrescriptionAccessNotFoundException();
        }

        if(!prescriptionAccessExisting.getAccess().equals(ACCESS.APPROVED)){
            if(prescriptionAccessExisting.getAccess().equals(ACCESS.PENDING)) {
                throw new ApprovalPendingException();
            } else if(prescriptionAccessExisting.getAccess().equals(ACCESS.DECLINED)){
                throw new PrescriptionDeclinedException();
            }
        }

        Optional<Prescription> optionalPrescription = prescriptionRepository.findById(prescriptionId);
        if(optionalPrescription.isPresent()){
            return optionalPrescription.get();
        }

        throw new PrescriptionNotFoundException();
    }
}
