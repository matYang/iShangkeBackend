package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.AccountHistoryEntity;

public class AccountHistoryEntityExt extends AccountHistoryEntity {
    private Set<Integer> idSet;
    private Set<Integer> userIdSet;
    private Set<Integer> withdrawIdSet;
    private Double chargeStart;
    private Double chargeEnd;
    private Set<Integer> typeSet;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;

    public Set<Integer> getIdSet() {
        return idSet;
    }

    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }

    public Set<Integer> getUserIdSet() {
        return userIdSet;
    }

    public void setUserIdSet(Set<Integer> userIdSet) {
        this.userIdSet = userIdSet;
    }

    public Set<Integer> getWithdrawIdSet() {
        return withdrawIdSet;
    }

    public void setWithdrawIdSet(Set<Integer> withdrawIdSet) {
        this.withdrawIdSet = withdrawIdSet;
    }

    public Double getChargeStart() {
        return chargeStart;
    }

    public void setChargeStart(Double chargeStart) {
        this.chargeStart = chargeStart;
    }

    public Double getChargeEnd() {
        return chargeEnd;
    }

    public void setChargeEnd(Double chargeEnd) {
        this.chargeEnd = chargeEnd;
    }

    public Set<Integer> getTypeSet() {
        return typeSet;
    }

    public void setTypeSet(Set<Integer> typeSet) {
        this.typeSet = typeSet;
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

}
