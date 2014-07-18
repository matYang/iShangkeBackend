package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.UserLocationEntity;

public class UserLocationEntityExt extends UserLocationEntity {
    private Set<Integer> idSet;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Set<Integer> userIdSet;
    private Set<Integer> locationIdSet;

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

    public Set<Integer> getUserIdSet() {
        return userIdSet;
    }

    public void setUserIdSet(Set<Integer> userIdSet) {
        this.userIdSet = userIdSet;
    }

    public Set<Integer> getLocationIdSet() {
        return locationIdSet;
    }

    public void setLocationIdSet(Set<Integer> locationIdSet) {
        this.locationIdSet = locationIdSet;
    }

}
