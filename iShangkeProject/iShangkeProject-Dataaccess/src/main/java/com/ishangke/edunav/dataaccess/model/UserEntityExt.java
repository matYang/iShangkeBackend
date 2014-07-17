package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.UserEntity;

public class UserEntityExt extends UserEntity {
    private Set<Integer> idSet;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    private Calendar lastLoginTimeStart;
    private Calendar lastLoginTimeEnd;
    private Calendar birthdayStart;
    private Calendar birthdayEnd;

    public Set<Integer> getIdSet() {
        return idSet;
    }

    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }

    public Calendar getLastModifyTimeStart() {
        return lastModifyTimeStart;
    }

    public void setLastModifyTimeStart(Calendar lastModifyTimeStart) {
        this.lastModifyTimeStart = lastModifyTimeStart;
    }

    public Calendar getLastModifyTimeEnd() {
        return lastModifyTimeEnd;
    }

    public void setLastModifyTimeEnd(Calendar lastModifyTimeEnd) {
        this.lastModifyTimeEnd = lastModifyTimeEnd;
    }

    public Calendar getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Calendar createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Calendar getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Calendar createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public Calendar getLastLoginTimeStart() {
        return lastLoginTimeStart;
    }

    public void setLastLoginTimeStart(Calendar lastLoginTimeStart) {
        this.lastLoginTimeStart = lastLoginTimeStart;
    }

    public Calendar getLastLoginTimeEnd() {
        return lastLoginTimeEnd;
    }

    public void setLastLoginTimeEnd(Calendar lastLoginTimeEnd) {
        this.lastLoginTimeEnd = lastLoginTimeEnd;
    }

    public Calendar getBirthdayStart() {
        return birthdayStart;
    }

    public void setBirthdayStart(Calendar birthdayStart) {
        this.birthdayStart = birthdayStart;
    }

    public Calendar getBirthdayEnd() {
        return birthdayEnd;
    }

    public void setBirthdayEnd(Calendar birthdayEnd) {
        this.birthdayEnd = birthdayEnd;
    }

}
