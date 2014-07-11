package com.ishangke.edunav.dataaccess.model;

import java.util.Date;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.UserLocationEntity;

public class UserLocationEntityExt extends UserLocationEntity {
    private int idStart;
    private int idEnd;
    private Set<Integer> idSet;
    private Date lastModifyTimeStart;
    private Date lastModifyTimeEnd;
    public int getIdStart() {
        return idStart;
    }
    public void setIdStart(int idStart) {
        this.idStart = idStart;
    }
    public int getIdEnd() {
        return idEnd;
    }
    public void setIdEnd(int idEnd) {
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
    
}
