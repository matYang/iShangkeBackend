package com.ishangke.edunav.web.model;

import com.ishangke.edunav.web.response.JsonResponse;

public class LoginVo extends JsonResponse {
    private Integer id;
    private String accountIdentifier;
    private String password;
    private Integer remmember;

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

    public Integer getRemember() {
        return this.remmember;
    }

    public void setRemember(Integer remember) {
        this.remmember = remember;
    }
}
