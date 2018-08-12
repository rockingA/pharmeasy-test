package com.pharmeasy.test.service;

import com.pharmeasy.test.entity.Role;

import java.util.Set;

public interface RoleService {

    Role save(Role role);

    Set<String> getAll();

    Role getRoleByName(String name);

}
