package com.ishangke.edunav.dataaccess.model;

import java.util.Date;

import com.ishangke.edunav.dataaccess.model.gen.AccountHistoryEntity;

public class AccountHistoryEntityExt extends AccountHistoryEntity {

    private int idStart;
    private int idEnd;
    private int idSet;
    private int userIdStart;
    private int userIdEnd;
    private int withdrawIdStart;
    private int withdrawIdEnd;
    private Double chargeStart;
    private Double chargeEnd;
    private int typeStart;
    private int typeEnd;
    private Date createTimeStart;
    private Date createTimeEnd;
    
    public int getIdSet() {
        return idSet;
    }
    public void setIdSet(int idSet) {
        this.idSet = idSet;
    }
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
    public int getWithdrawIdStart() {
        return withdrawIdStart;
    }
    public void setWithdrawIdStart(int withdrawIdStart) {
        this.withdrawIdStart = withdrawIdStart;
    }
    public int getWithdrawIdEnd() {
        return withdrawIdEnd;
    }
    public void setWithdrawIdEnd(int withdrawIdEnd) {
        this.withdrawIdEnd = withdrawIdEnd;
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
    public int getTypeStart() {
        return typeStart;
    }
    public void setTypeStart(int typeStart) {
        this.typeStart = typeStart;
    }
    public int getTypeEnd() {
        return typeEnd;
    }
    public void setTypeEnd(int typeEnd) {
        this.typeEnd = typeEnd;
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
