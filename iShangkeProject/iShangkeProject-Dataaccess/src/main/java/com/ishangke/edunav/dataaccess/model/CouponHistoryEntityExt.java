package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.CouponHistoryEntity;

public class CouponHistoryEntityExt extends CouponHistoryEntity {
    private Set<Integer> idSet;
    private Set<Integer> couponIdSet;
    private Double chargeStart;
    private Double chargeEnd;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    private Set<Integer> operationSet;
    public Set<Integer> getIdSet() {
        return idSet;
    }

    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }

    public Set<Integer> getCouponIdSet() {
        return couponIdSet;
    }

    public void setCouponIdSet(Set<Integer> couponIdSet) {
        this.couponIdSet = couponIdSet;
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

    public Set<Integer> getOperationSet() {
        return operationSet;
    }

    public void setOperationSet(Set<Integer> operationSet) {
        this.operationSet = operationSet;
    }

}
