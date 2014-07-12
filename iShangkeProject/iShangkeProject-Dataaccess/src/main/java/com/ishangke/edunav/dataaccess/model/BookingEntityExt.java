package com.ishangke.edunav.dataaccess.model;

import java.util.Date;

import com.ishangke.edunav.dataaccess.model.gen.BookingEntity;

public class BookingEntityExt extends BookingEntity {

    private int idStart;
    private int idEnd;
    private int courseIdStart;
    private int courseIdEnd;
    private int userIdStart;
    private int userIdEnd;
    private int statusStart;
    private int statusEnd;
    private Date scheduledTimeStart;
    private Date scheduledTimeEnd;
    private Date noRefundDateStart;
    private Date noRefundDateEnd;
    private Date cashbackDateStart;
    private Date cashbackDateEnd;
    private int typeStart;
    private int typeEnd;
    private Double cashbackAmountStart;
    private Double cashbackAmountEnd;
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
    public int getCourseIdStart() {
        return courseIdStart;
    }
    public void setCourseIdStart(int courseIdStart) {
        this.courseIdStart = courseIdStart;
    }
    public int getCourseIdEnd() {
        return courseIdEnd;
    }
    public void setCourseIdEnd(int courseIdEnd) {
        this.courseIdEnd = courseIdEnd;
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
    public int getStatusStart() {
        return statusStart;
    }
    public void setStatusStart(int statusStart) {
        this.statusStart = statusStart;
    }
    public int getStatusEnd() {
        return statusEnd;
    }
    public void setStatusEnd(int statusEnd) {
        this.statusEnd = statusEnd;
    }
    public Date getScheduledTimeStart() {
        return scheduledTimeStart;
    }
    public void setScheduledTimeStart(Date scheduledTimeStart) {
        this.scheduledTimeStart = scheduledTimeStart;
    }
    public Date getScheduledTimeEnd() {
        return scheduledTimeEnd;
    }
    public void setScheduledTimeEnd(Date scheduledTimeEnd) {
        this.scheduledTimeEnd = scheduledTimeEnd;
    }
    public Date getNoRefundDateStart() {
        return noRefundDateStart;
    }
    public void setNoRefundDateStart(Date noRefundDateStart) {
        this.noRefundDateStart = noRefundDateStart;
    }
    public Date getNoRefundDateEnd() {
        return noRefundDateEnd;
    }
    public void setNoRefundDateEnd(Date noRefundDateEnd) {
        this.noRefundDateEnd = noRefundDateEnd;
    }
    public Date getCashbackDateStart() {
        return cashbackDateStart;
    }
    public void setCashbackDateStart(Date cashbackDateStart) {
        this.cashbackDateStart = cashbackDateStart;
    }
    public Date getCashbackDateEnd() {
        return cashbackDateEnd;
    }
    public void setCashbackDateEnd(Date cashbackDateEnd) {
        this.cashbackDateEnd = cashbackDateEnd;
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
    public Double getCashbackAmountStart() {
        return cashbackAmountStart;
    }
    public void setCashbackAmountStart(Double cashbackAmountStart) {
        this.cashbackAmountStart = cashbackAmountStart;
    }
    public Double getCashbackAmountEnd() {
        return cashbackAmountEnd;
    }
    public void setCashbackAmountEnd(Double cashbackAmountEnd) {
        this.cashbackAmountEnd = cashbackAmountEnd;
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
