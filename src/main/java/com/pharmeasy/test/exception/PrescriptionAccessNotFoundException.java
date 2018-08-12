package com.pharmeasy.test.exception;


import com.pharmeasy.test.model.APIResponseKey;

public class PrescriptionAccessNotFoundException extends RuntimeException implements ApiException {

    private  static final APIResponseKey purpose=APIResponseKey.PRESCRIPTON_ACCESS_NOT_FOUND;

    @Override
    public APIResponseKey getApiResponseKey() {
        return purpose;
    }
}
