package com.pharmeasy.test.exception;


import com.pharmeasy.test.model.APIResponseKey;


public class ApprovalPendingException extends RuntimeException implements ApiException {

    private  static final APIResponseKey purpose=APIResponseKey.APPROVAL_PENDING;

    @Override
    public APIResponseKey getApiResponseKey() {
        return purpose;
    }
}
