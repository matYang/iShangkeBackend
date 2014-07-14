package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;

import com.ishangke.edunav.dataaccess.model.gen.CreditHistoryEntity;

public class CreditHistoryEntityExt extends CreditHistoryEntity {

    private Integer idStart;
    private Integer idEnd;
    private Double chargeStart;
    private Double chargeEnd;
    private Integer userIdStart;
    private Integer userIdEnd;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    
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
