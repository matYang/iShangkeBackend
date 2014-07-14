package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.AccountEntity;

public class AccountEntityExt extends AccountEntity {
    private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;
    private Double balanceStart;
    private Double balanceEnd;
    private Calendar lastModifyTimeBefore;
    private Calendar lastModifyTimeAfter;
    private Calendar createTimeBefore;
    private Calendar createTimeAfter;

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

    public Calendar getLastModifyTimeBefore() {
        return lastModifyTimeBefore;
    }

    public void setLastModifyTimeBefore(Calendar lastModifyTimeBefore) {
        this.lastModifyTimeBefore = lastModifyTimeBefore;
    }

    public Calendar getLastModifyTimeAfter() {
        return lastModifyTimeAfter;
    }

    public void setLastModifyTimeAfter(Calendar lastModifyTimeAfter) {
        this.lastModifyTimeAfter = lastModifyTimeAfter;
    }

    public Calendar getCreateTimeBefore() {
        return createTimeBefore;
    }

    public void setCreateTimeBefore(Calendar createTimeBefore) {
        this.createTimeBefore = createTimeBefore;
    }

    public Calendar getCreateTimeAfter() {
        return createTimeAfter;
    }

    public void setCreateTimeAfter(Calendar createTimeAfter) {
        this.createTimeAfter = createTimeAfter;
    }
}
