package com.ishangke.edunav.dataaccess.model;

import java.util.Date;

import com.ishangke.edunav.dataaccess.model.gen.CouponEntity;

public class CouponEntityExt extends CouponEntity {

    private int idStart;
    private int idEnd;
    private Double totalStart;
    private Double totalEnd;
    private Double balanceStart;
    private Double balanceEnd;
    private Date expiryTimeStart;
    private Date expiryTimeEnd;
    private int userIdStart;
    private int userIdEnd;
    private Date lastModifyTimeStart;
    private Date lastModifyTimeEnd;
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
    public Date getExpiryTimeStart() {
        return expiryTimeStart;
    }
    public void setExpiryTimeStart(Date expiryTimeStart) {
        this.expiryTimeStart = expiryTimeStart;
    }
    public Date getExpiryTimeEnd() {
        return expiryTimeEnd;
    }
    public void setExpiryTimeEnd(Date expiryTimeEnd) {
        this.expiryTimeEnd = expiryTimeEnd;
    }
    public int getUserIdStart() {
        return userIdStart;
    }
    public void setUserIdStart(int userIdStart) {
        this.userIdStart = userIdStart;
    }
    public int getUserIdEnd() {
        return userIdEnd;
    }
    public void setUserIdEnd(int userIdEnd) {
        this.userIdEnd = userIdEnd;
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
