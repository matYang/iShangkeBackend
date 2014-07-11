package com.ishangke.edunav.dataaccess.model;

import java.util.Date;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.WithdrawEntity;

public class WithdrawEntityExt extends WithdrawEntity {
    private int idStart;
    private int idEnd;
    private Set<Integer> idSet;
    private Date lastModifyNameStart;
    private Date lastModifyNameEnd;
    private Date createTimeStart;
    private Date createTimeEnd;
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
    public Date getLastModifyNameStart() {
        return lastModifyNameStart;
    }
    public void setLastModifyNameStart(Date lastModifyNameStart) {
        this.lastModifyNameStart = lastModifyNameStart;
    }
    public Date getLastModifyNameEnd() {
        return lastModifyNameEnd;
    }
    public void setLastModifyNameEnd(Date lastModifyNameEnd) {
        this.lastModifyNameEnd = lastModifyNameEnd;
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
}
