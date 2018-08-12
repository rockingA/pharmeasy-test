package com.pharmeasy.test.controller;

import com.pharmeasy.test.entity.Prescription;
import com.pharmeasy.test.entity.PrescriptionAccess;
import com.pharmeasy.test.model.APIResponseKey;
import com.pharmeasy.test.model.ApiResponse;
import com.pharmeasy.test.model.dto.AccessActionDTO;
import com.pharmeasy.test.model.dto.PrescriptionRequestAccessDto;
import com.pharmeasy.test.service.PrescriptionAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/prescriptionAccess")
public class PrescriptionAccessController {

    @Autowired
    PrescriptionAccessService prescriptionAccessService;

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public ApiResponse<String> addPrescriptionRequest(@RequestBody PrescriptionRequestAccessDto prescriptionRequestAccessDto){

        PrescriptionAccess prescriptionAccess = prescriptionAccessService.requestPrescriptionAccess
                (prescriptionRequestAccessDto.getPrescriptionId(),prescriptionRequestAccessDto.getFrom(),
                        prescriptionRequestAccessDto.getTo());
        return new ApiResponse<>(APIResponseKey.APPROVAL_PENDING,prescriptionAccess.getId().toString(),null);
    }


    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/subject/{subjectId}/getAllPendingApprovals")
    ApiResponse<List<PrescriptionAccess>> getAllPendingApprovals(@PathVariable("subjectId") Long subjectId){

        return new ApiResponse<>(APIResponseKey.ALL_GOOD,prescriptionAccessService.getAllPendingSubscription(subjectId),null);
    }


    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/subject/{subjectId}/accessAction", consumes = "application/json")
    public ApiResponse<PrescriptionAccess> addAcessAction(
            @PathVariable("subjectId") Long subjectId,
            @RequestBody AccessActionDTO accessActionDTO){

        return new ApiResponse<>(APIResponseKey.ALL_GOOD,prescriptionAccessService.doAction(subjectId,accessActionDTO),null);
    }


    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(value = "from/{from}/to/{to}/prescription/{prescriptionId}")
    public ApiResponse<Prescription> getPrescription(
            @PathVariable("from") Long from,
            @PathVariable("to") Long to,
            @PathVariable("prescriptionId") Long prescriptionId
           ){

        return new ApiResponse<>(APIResponseKey.ALL_GOOD,prescriptionAccessService.getPrescription(from,to,prescriptionId),null);
    }




}
