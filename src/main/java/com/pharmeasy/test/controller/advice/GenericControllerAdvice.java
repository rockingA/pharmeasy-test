package com.pharmeasy.test.controller.advice;

import com.pharmeasy.test.exception.*;
import com.pharmeasy.test.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.pharmeasy.test.model.Error;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GenericControllerAdvice {

    @ExceptionHandler(ApprovalPendingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ApiResponse<Void> handleApprovalPendingException(ApprovalPendingException e){
        List<Error> errors = new ArrayList<>();
        errors.add(new Error(e.getApiResponseKey().getCode(), e.getApiResponseKey().getMessage()));

        return new ApiResponse<>(e.getApiResponseKey(),null,errors);
    }

    @ExceptionHandler(PrescriptionAccessAlreadyRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ApiResponse<Void> handlePrescriptionAccessAlreadyRequestException(PrescriptionAccessAlreadyRequestException e){
        List<Error> errors = new ArrayList<>();
        errors.add(new Error(e.getApiResponseKey().getCode(), e.getApiResponseKey().getMessage()));

        return new ApiResponse<>(e.getApiResponseKey(),null,errors);
    }

    @ExceptionHandler(PrescriptionDeclinedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ApiResponse<Void> handlePrescriptionDeclinedException(PrescriptionDeclinedException e){
        List<Error> errors = new ArrayList<>();
        errors.add(new Error(e.getApiResponseKey().getCode(), e.getApiResponseKey().getMessage()));

        return new ApiResponse<>(e.getApiResponseKey(),null,errors);
    }


    @ExceptionHandler(PrescriptionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    ApiResponse<Void> handlePrescriptionNotFoundException(PrescriptionNotFoundException e){
        List<Error> errors = new ArrayList<>();
        errors.add(new Error(e.getApiResponseKey().getCode(), e.getApiResponseKey().getMessage()));

        return new ApiResponse<>(e.getApiResponseKey(),null,errors);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    ApiResponse<Void> handleRoleNotFoundException(RoleNotFoundException e){
        List<Error> errors = new ArrayList<>();
        errors.add(new Error(e.getApiResponseKey().getCode(), e.getApiResponseKey().getMessage()));

        return new ApiResponse<>(e.getApiResponseKey(),null,errors);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody
    ApiResponse<Void> handleUserAlreadyExistsException(UserAlreadyExistsException e){
        List<Error> errors = new ArrayList<>();
        errors.add(new Error(e.getApiResponseKey().getCode(), e.getApiResponseKey().getMessage()));

        return new ApiResponse<>(e.getApiResponseKey(),null,errors);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    ApiResponse<Void> handleUserNotFoundException(UserNotFoundException e){
        List<Error> errors = new ArrayList<>();
        errors.add(new Error(e.getApiResponseKey().getCode(), e.getApiResponseKey().getMessage()));

        return new ApiResponse<>(e.getApiResponseKey(),null,errors);
    }

    @ExceptionHandler(PrescriptionAccessNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    ApiResponse<Void> handlePrescriptionAccessNotFoundException(PrescriptionAccessNotFoundException e){
        List<Error> errors = new ArrayList<>();
        errors.add(new Error(e.getApiResponseKey().getCode(), e.getApiResponseKey().getMessage()));

        return new ApiResponse<>(e.getApiResponseKey(),null,errors);
    }

    @ExceptionHandler(PrescriptionAccessNotYoursException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ApiResponse<Void> handlePrescriptionAccessNotYoursException(PrescriptionAccessNotYoursException e){
        List<Error> errors = new ArrayList<>();
        errors.add(new Error(e.getApiResponseKey().getCode(), e.getApiResponseKey().getMessage()));

        return new ApiResponse<>(e.getApiResponseKey(),null,errors);
    }
}
