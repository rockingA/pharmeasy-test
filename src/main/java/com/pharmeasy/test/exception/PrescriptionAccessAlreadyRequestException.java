package com.pharmeasy.test.exception;


import com.pharmeasy.test.model.APIResponseKey;

public class PrescriptionAccessAlreadyRequestException extends RuntimeException implements ApiException {

    private  static final APIResponseKey purpose=APIResponseKey.PRESCRIPTON_ACCESS_ALREADY_EXISTS;

    @Override
    public APIResponseKey getApiResponseKey() {
        return purpose;
    }
}
