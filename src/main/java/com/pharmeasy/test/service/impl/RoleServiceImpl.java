package com.pharmeasy.test.service.impl;

import com.pharmeasy.test.entity.Role;
import com.pharmeasy.test.exception.RoleNotFoundException;
import com.pharmeasy.test.repository.RoleRepository;
import com.pharmeasy.test.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public Role save(Role role) {
        role.setRoleName(role.getRoleName().toUpperCase());
        Role roleExisting = roleRepository.findFirstByRoleName(role.getRoleName());
        if(roleExisting != null){
            return roleExisting;
        }
        return roleRepository.save(role);
    }

    @Override
    public Set<String> getAll() {
        List<Role> roles = roleRepository.findAll();
        if(roles != null && roles.size() > 0){
            Set<String> strings = new HashSet<>();
            for (Role role: roles ) {
                strings.add(role.getRoleName());
            }
            return strings;
        }
        return null;
    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        Role role = roleRepository.findFirstByRoleName(name.toUpperCase());
        if(role != null){
            return role;
        }

        throw new RoleNotFoundException();
    }
}
