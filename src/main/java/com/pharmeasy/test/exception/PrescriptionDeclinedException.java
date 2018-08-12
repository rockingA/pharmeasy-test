package com.pharmeasy.test.exception;


import com.pharmeasy.test.model.APIResponseKey;

public class PrescriptionDeclinedException extends RuntimeException implements ApiException {

    private  static final APIResponseKey purpose=APIResponseKey.PRESCRIPTION_APPROVAL_DECLINED;

    @Override
    public APIResponseKey getApiResponseKey() {
        return purpose;
    }
}
