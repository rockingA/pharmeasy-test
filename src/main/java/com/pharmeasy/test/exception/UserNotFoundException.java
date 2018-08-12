package com.pharmeasy.test.exception;


import com.pharmeasy.test.model.APIResponseKey;

public class UserNotFoundException extends RuntimeException implements ApiException {

    private  static final APIResponseKey purpose=APIResponseKey.USER_NOT_FOUND;

    @Override
    public APIResponseKey getApiResponseKey() {
        return purpose;
    }
}
