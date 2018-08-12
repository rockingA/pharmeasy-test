package com.pharmeasy.test.model.dto;

import com.pharmeasy.test.entity.ACCESS;

public class AccessActionDTO {

    private Long accessId;
    private ACCESS access;

    public Long getAccessId() {
        return accessId;
    }

    public void setAccessId(Long accessId) {
        this.accessId = accessId;
    }

    public ACCESS getAccess() {
        return access;
    }

    public void setAccess(ACCESS access) {
        this.access = access;
    }
}
