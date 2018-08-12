package com.pharmeasy.test.exception;


import com.pharmeasy.test.model.APIResponseKey;

public class PrescriptionNotFoundException extends RuntimeException implements ApiException {

    private  static final APIResponseKey purpose=APIResponseKey.PRESCRIPTION_NOT_FOUND;

    @Override
    public APIResponseKey getApiResponseKey() {
        return purpose;
    }
}
