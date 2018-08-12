package com.pharmeasy.test.service;

import com.pharmeasy.test.entity.Prescription;
import com.pharmeasy.test.entity.Subject;

public interface SubjectService {

    Subject save(Subject subject);

    Subject getSubjectById(Long id);

    Subject addPrescription(Long id, Prescription prescription);

    Subject addRole(Long id, String roleName);

}
