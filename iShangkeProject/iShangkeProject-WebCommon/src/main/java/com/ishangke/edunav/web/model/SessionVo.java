package com.ishangke.edunav.web.model;

import com.ishangke.edunav.web.response.JsonResponse;

public class SessionVo extends JsonResponse {
    private Integer id;
    private String accountIdentifier;
    private String authCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
