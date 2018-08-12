package com.pharmeasy.test.controller;

import com.pharmeasy.test.entity.Prescription;
import com.pharmeasy.test.entity.Subject;
import com.pharmeasy.test.model.APIResponseKey;
import com.pharmeasy.test.model.ApiResponse;
import com.pharmeasy.test.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public ApiResponse<Subject> createSubject(@RequestBody Subject subject){

        return new ApiResponse<>(APIResponseKey.ALL_GOOD,subjectService.save(subject),null);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{subjectId}")
    public ApiResponse<Subject> getSubject(@PathVariable("subjectId") Long subjectId){

        return new ApiResponse<>(APIResponseKey.ALL_GOOD,subjectService.getSubjectById(subjectId),null);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{subjectId}/addRole")
    public ApiResponse<Subject> getSubject(@PathVariable("subjectId") Long subjectId,@RequestBody String role){

        return new ApiResponse<>(APIResponseKey.ALL_GOOD,subjectService.addRole(subjectId,role),null);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{subjectId}/addPrescription", consumes = "application/json")
    public ApiResponse<Subject> addPrescription(@PathVariable("subjectId") Long subjectId,
                                                @RequestBody Prescription prescription){

        return new ApiResponse<>(APIResponseKey.ALL_GOOD,subjectService.addPrescription(subjectId,prescription),null);
    }

}
