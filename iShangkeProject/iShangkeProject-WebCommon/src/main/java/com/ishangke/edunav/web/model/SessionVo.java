package com.ishangke.edunav.web.model;

public class SessionVo {
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
