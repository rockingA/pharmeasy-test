package com.pharmeasy.test.controller;

import com.pharmeasy.test.entity.Role;
import com.pharmeasy.test.model.APIResponseKey;
import com.pharmeasy.test.model.ApiResponse;
import com.pharmeasy.test.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public ApiResponse<Role> createRole(@RequestBody Role role){
        return new ApiResponse<>(APIResponseKey.ALL_GOOD,roleService.save(role),null);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ApiResponse<Set<String>> createRole(){
        return new ApiResponse<>(APIResponseKey.ALL_GOOD,roleService.getAll(),null);
    }
}
