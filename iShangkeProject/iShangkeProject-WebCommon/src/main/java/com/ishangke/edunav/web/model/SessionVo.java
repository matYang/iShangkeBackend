package com.ishangke.edunav.web.model;

public class SessionVo {
    private Integer id;
    private Integer accountIdentifier;
    private String authCode;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getAccountIdentifier() {
        return accountIdentifier;
    }
    public void setAccountIdentifier(Integer accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }
    public String getAuthCode() {
        return authCode;
    }
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
