package com.ishangke.edunav.web.model;

public class LoginVo {
    private Integer id;
    private String accountIdentifier;
    private String password;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
