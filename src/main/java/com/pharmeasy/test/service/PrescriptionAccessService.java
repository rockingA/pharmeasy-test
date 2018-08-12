package com.pharmeasy.test.service;

import com.pharmeasy.test.entity.Prescription;
import com.pharmeasy.test.entity.PrescriptionAccess;
import com.pharmeasy.test.model.dto.AccessActionDTO;

import java.util.List;

public interface PrescriptionAccessService {

    PrescriptionAccess requestPrescriptionAccess(Long prescriptionId, Long from, Long to);

    Boolean hasAccess(Long prescriptionId, Long from, Long to);

    PrescriptionAccess getById(Long id);

    List<PrescriptionAccess> getAllPendingSubscription(Long subjectId);

    PrescriptionAccess doAction(Long subjectId, AccessActionDTO accessActionDTO);

    Prescription getPrescription(Long from, Long to, Long prescriptionId);
}
