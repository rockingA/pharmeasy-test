package com.pharmeasy.test.model;


public enum APIResponseKey {
    ALL_GOOD(2000, "Everything's good."),
    NEW_CREATION(1001, "New resource created."),
    USER_ALREADY_EXISTS(4004,"User with same mobile or email already exists" ),
    APPROVAL_PENDING(4012,"Approval is pending from user" ),
    PRESCRIPTION_APPROVAL_DECLINED(4013,"Approval is declined by user" ),
    USER_NOT_FOUND(4014,"User Not Found" ),
    ROLE_NOT_FOUND(4005,"Role Not found" ),
    PRESCRIPTION_NOT_FOUND(4006,"Prescription Not Found" ),
    PRESCRIPTON_ACCESS_ALREADY_EXISTS(4007,"Prescription Access Already found" ),
    PRESCRIPTON_ACCESS_NOT_FOUND(4008,"Prescription Access Not Found" ),
    PRESCRIPTON_ACCESS_NOT_YOURS(4009,"Prescription Access is not Your's, You cannot change it" );

    private int code;
    private String message;

    APIResponseKey(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
