package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.CouponEntity;

public class CouponEntityExt extends CouponEntity {
    private Set<Integer> idSet;
    private Double totalStart;
    private Double totalEnd;
    private Double balanceStart;
    private Double balanceEnd;
    private Set<Integer> originSet;
    private Calendar expiryTimeStart;
    private Calendar expiryTimeEnd;
    private Set<Integer> userIdSet;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    private Set<Integer> statusSet;
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

    public Set<Integer> getOriginSet() {
        return originSet;
    }

    public void setOriginSet(Set<Integer> originSet) {
        this.originSet = originSet;
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

    public Set<Integer> getStatusSet() {
        return statusSet;
    }

    public void setStatusSet(Set<Integer> statusSet) {
        this.statusSet = statusSet;
    }

}
