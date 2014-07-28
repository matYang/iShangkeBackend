package com.ishangke.edunav.web.model;

import java.util.Calendar;
import java.util.Set;

public class CouponVo {
    private Integer id;

    private String code;

    private Double total;

    private Double balance;

    private Integer origin;

    private Calendar expiryTime;

    private String remark;

    private Integer userId;

    private Calendar lastModifyTime;

    private Calendar createTime;

    private Integer enabled;
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
    private Integer status;
    private Set<Integer> statusSet;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public Integer getOrigin() {
        return origin;
    }
    public void setOrigin(Integer origin) {
        this.origin = origin;
    }
    public Calendar getExpiryTime() {
        return expiryTime;
    }
    public void setExpiryTime(Calendar expiryTime) {
        this.expiryTime = expiryTime;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
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
    public Integer getEnabled() {
        return enabled;
    }
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
    public Set<Integer> getIdSet() {
        return idSet;
    }
    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
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
    public Set<Integer> getOriginSet() {
        return originSet;
    }
    public void setOriginSet(Set<Integer> originSet) {
        this.originSet = originSet;
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
    public Set<Integer> getUserIdSet() {
        return userIdSet;
    }
    public void setUserIdSet(Set<Integer> userIdSet) {
        this.userIdSet = userIdSet;
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
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Set<Integer> getStatusSet() {
        return statusSet;
    }
    public void setStatusSet(Set<Integer> statusSet) {
        this.statusSet = statusSet;
    }
    
}
