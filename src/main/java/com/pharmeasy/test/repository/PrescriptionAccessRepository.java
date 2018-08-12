package com.pharmeasy.test.repository;

import com.pharmeasy.test.entity.ACCESS;
import com.pharmeasy.test.entity.Prescription;
import com.pharmeasy.test.entity.PrescriptionAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionAccessRepository extends JpaRepository<PrescriptionAccess,Long> {

    PrescriptionAccess findFirstByFromExtraAndToExtraAndPrescriptionId(Long from, Long to, Long prescriptionId);

    List<PrescriptionAccess> findAllByToExtraAndAccess(Long to, ACCESS access);
}
