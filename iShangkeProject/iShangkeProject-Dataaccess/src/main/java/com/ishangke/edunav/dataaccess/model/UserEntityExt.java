package com.ishangke.edunav.dataaccess.model;

import java.util.Date;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.UserEntity;

public class UserEntityExt extends UserEntity {
    private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;
    private Date lastModifyTimeStart;
    private Date lastModifyTimeEnd;
    private Date createTimeStart;
    private Date createTimeEnd;
    private Date lastLoginTimeStart;
    private Date lastLoginTimeEnd;
    private Date birthdayStart;
    private Date birthdayEnd;
    public Integer getIdStart() {
        return idStart;
    }
    public void setIdStart(Integer idStart) {
        this.idStart = idStart;
    }
    public Integer getIdEnd() {
        return idEnd;
    }
    public void setIdEnd(Integer idEnd) {
        this.idEnd = idEnd;
    }
    public Set<Integer> getIdSet() {
        return idSet;
    }
    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }
    public Date getLastModifyTimeStart() {
        return lastModifyTimeStart;
    }
    public void setLastModifyTimeStart(Date lastModifyTimeStart) {
        this.lastModifyTimeStart = lastModifyTimeStart;
    }
    public Date getLastModifyTimeEnd() {
        return lastModifyTimeEnd;
    }
    public void setLastModifyTimeEnd(Date lastModifyTimeEnd) {
        this.lastModifyTimeEnd = lastModifyTimeEnd;
    }
    public Date getCreateTimeStart() {
        return createTimeStart;
    }
    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }
    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }
    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
    public Date getLastLoginTimeStart() {
        return lastLoginTimeStart;
    }
    public void setLastLoginTimeStart(Date lastLoginTimeStart) {
        this.lastLoginTimeStart = lastLoginTimeStart;
    }
    public Date getLastLoginTimeEnd() {
        return lastLoginTimeEnd;
    }
    public void setLastLoginTimeEnd(Date lastLoginTimeEnd) {
        this.lastLoginTimeEnd = lastLoginTimeEnd;
    }
    public Date getBirthdayStart() {
        return birthdayStart;
    }
    public void setBirthdayStart(Date birthdayStart) {
        this.birthdayStart = birthdayStart;
    }
    public Date getBirthdayEnd() {
        return birthdayEnd;
    }
    public void setBirthdayEnd(Date birthdayEnd) {
        this.birthdayEnd = birthdayEnd;
    }
    
}
