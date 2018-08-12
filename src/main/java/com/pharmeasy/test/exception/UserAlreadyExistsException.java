package com.pharmeasy.test.exception;


import com.pharmeasy.test.model.APIResponseKey;

public class UserAlreadyExistsException extends RuntimeException implements ApiException {

    private  static final APIResponseKey purpose=APIResponseKey.USER_ALREADY_EXISTS;

    @Override
    public APIResponseKey getApiResponseKey() {
        return purpose;
    }
}
