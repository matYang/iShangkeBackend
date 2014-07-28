package com.ishangke.edunav.web.model;

import java.util.Calendar;
import java.util.Set;

public class CouponHistoryVo {
    private Integer id;

    private Integer couponId;

    private Double charge;

    private Calendar lastModifyTime;

    private Calendar createTime;
    private Set<Integer> idSet;
    private Set<Integer> couponIdSet;
    private Double chargeStart;
    private Double chargeEnd;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    private Integer operation;
    private Set<Integer> operationSet;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCouponId() {
        return couponId;
    }
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }
    public Double getCharge() {
        return charge;
    }
    public void setCharge(Double charge) {
        this.charge = charge;
    }
    public Calendar getLastModifyTime() {
        return lastModifyTime;
    }
    public void setLastModifyTime(Calendar lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
    public Calendar getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Calendar createTime) {
        this.createTime = createTime;
    }
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
    public Integer getOperation() {
        return operation;
    }
    public void setOperation(Integer operation) {
        this.operation = operation;
    }
    public Set<Integer> getOperationSet() {
        return operationSet;
    }
    public void setOperationSet(Set<Integer> operationSet) {
        this.operationSet = operationSet;
    }
    
}
