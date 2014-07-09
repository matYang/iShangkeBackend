package com.ishangke.edunav.dataaccess.model;

import java.util.Date;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.AccountEntity;

public class AccountEntityExt extends AccountEntity {
    private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;
    private Double balanceStart;
    private Double balanceEnd;
    private Date lastModifyTimeBefore;
    private Date lastModifyTimeAfter;
    private Date createTimeBefore;
    private Date createTimeAfter;

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

    public Double getBalanceStart() {
        return balanceStart;
    }

    public void setBalanceStart(Double balanceStart) {
        this.balanceStart = balanceStart;
    }

    public Double getBalanceEnd() {
        return balanceEnd;
    }

    public void setBalanceEnd(Double balanceEnd) {
        this.balanceEnd = balanceEnd;
    }

    public Date getLastModifyTimeBefore() {
        return lastModifyTimeBefore;
    }

    public void setLastModifyTimeBefore(Date lastModifyTimeBefore) {
        this.lastModifyTimeBefore = lastModifyTimeBefore;
    }

    public Date getLastModifyTimeAfter() {
        return lastModifyTimeAfter;
    }

    public void setLastModifyTimeAfter(Date lastModifyTimeAfter) {
        this.lastModifyTimeAfter = lastModifyTimeAfter;
    }

    public Date getCreateTimeBefore() {
        return createTimeBefore;
    }

    public void setCreateTimeBefore(Date createTimeBefore) {
        this.createTimeBefore = createTimeBefore;
    }

    public Date getCreateTimeAfter() {
        return createTimeAfter;
    }

    public void setCreateTimeAfter(Date createTimeAfter) {
        this.createTimeAfter = createTimeAfter;
    }
}
