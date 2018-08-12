package com.pharmeasy.test.repository;

import com.pharmeasy.test.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

    List<Subject> findByMobileNumberOrEmailId(String mobileNumber, String emailId);
    Subject findFirstByMobileNumber(String mobile);
    Subject findFirstByEmailId(String email);
}
