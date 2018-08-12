package com.pharmeasy.test.repository;

import com.pharmeasy.test.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findFirstByRoleName(String name);

}
