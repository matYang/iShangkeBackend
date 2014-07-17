package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.CouponEntity;

public class CouponEntityExt extends CouponEntity {

    private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;
    private Double totalStart;
    private Double totalEnd;
    private Double balanceStart;
    private Double balanceEnd;
    private Calendar expiryTimeStart;
    private Calendar expiryTimeEnd;
    private Integer userIdStart;
    private Integer userIdEnd;
    private Set<Integer> userIdSet;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
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
    public Double getTotalStart() {
        return totalStart;
    }
    public void setTotalStart(Double totalStart) {
        this.totalStart = totalStart;
    }
    public Double getTotalEnd() {
        return totalEnd;
    }
    public void setTotalEnd(Double totalEnd) {
        this.totalEnd = totalEnd;
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
    public Calendar getExpiryTimeStart() {
        return expiryTimeStart;
    }
    public void setExpiryTimeStart(Calendar expiryTimeStart) {
        this.expiryTimeStart = expiryTimeStart;
    }
    public Calendar getExpiryTimeEnd() {
        return expiryTimeEnd;
    }
    public void setExpiryTimeEnd(Calendar expiryTimeEnd) {
        this.expiryTimeEnd = expiryTimeEnd;
    }
    public Integer getUserIdStart() {
        return userIdStart;
    }
    public void setUserIdStart(Integer userIdStart) {
        this.userIdStart = userIdStart;
    }
    public Integer getUserIdEnd() {
        return userIdEnd;
    }
    public void setUserIdEnd(Integer userIdEnd) {
        this.userIdEnd = userIdEnd;
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
    
}
