package com.pharmeasy.test.service.impl;

import com.pharmeasy.test.entity.Prescription;
import com.pharmeasy.test.entity.Role;
import com.pharmeasy.test.entity.Subject;
import com.pharmeasy.test.exception.UserAlreadyExistsException;
import com.pharmeasy.test.exception.UserNotFoundException;
import com.pharmeasy.test.repository.SubjectRepository;
import com.pharmeasy.test.service.RoleService;
import com.pharmeasy.test.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    RoleService roleService;

    @Override
    @Transactional
    public Subject save(Subject subject) {
        if(subject.getEmailId() != null){
            subject.setEmailId(subject.getEmailId().toLowerCase());
        }
        validateBeforeSave(subject);
        return subjectRepository.save(subject);
    }

    @Override
    @Transactional
    public Subject getSubjectById(Long id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if(optionalSubject.isPresent()){
            return optionalSubject.get();
        }
        throw new UserNotFoundException();
    }

    @Override
    @Transactional
    public Subject addPrescription(Long id, Prescription prescription) {
        Subject subject = getSubjectById(id);
        Set<Prescription> prescriptions = subject.getPrescriptions();
        prescriptions.add(prescription);
        subject.setPrescriptions(prescriptions);
        return subjectRepository.save(subject);
    }

    @Override
    public Subject addRole(Long id, String roleName) {
        Subject subject = getSubjectById(id);
        Role role = roleService.getRoleByName(roleName);
        Set<Role> roles = subject.getRoles();
        roles.add(role);
        subject.setRoles(roles);
        return subjectRepository.save(subject);
    }

    private boolean validateBeforeSave(Subject subject){
        String mobile = subject.getMobileNumber();
        String email = subject.getEmailId();
        if(mobile != null && email != null){
            List<Subject> subjects = subjectRepository.findByMobileNumberOrEmailId(mobile,email);
            if(subjects != null && subjects.size() > 0){
                throw new UserAlreadyExistsException();
            }
        } else {
            if(mobile != null){
                Subject subjectExisting = subjectRepository.findFirstByMobileNumber(mobile);
                if(subjectExisting != null){
                    throw new UserAlreadyExistsException();
                }
            }
            if(email != null){
                Subject subjectExisting =subjectRepository.findFirstByEmailId(email);
                if(subjectExisting != null){
                    throw new UserAlreadyExistsException();
                }
            }
        }

        return true;
    }
}
