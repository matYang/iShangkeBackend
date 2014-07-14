package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;

import com.ishangke.edunav.dataaccess.model.gen.BookingEntity;

public class BookingEntityExt extends BookingEntity {

    private Integer idStart;
    private Integer idEnd;
    private Integer idSet;
    private Integer courseIdStart;
    private Integer courseIdEnd;
    private Integer userIdStart;
    private Integer userIdEnd;
    private Integer statusStart;
    private Integer statusEnd;
    private Calendar scheduledTimeStart;
    private Calendar scheduledTimeEnd;
    private Calendar noRefundDateStart;
    private Calendar noRefundDateEnd;
    private Calendar cashbackDateStart;
    private Calendar cashbackDateEnd;
    private Integer typeStart;
    private Integer typeEnd;
    private Double cashbackAmountStart;
    private Double cashbackAmountEnd;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    
    public Integer getIdSet() {
        return idSet;
    }
    public void setIdSet(Integer idSet) {
        this.idSet = idSet;
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
    public Integer getCourseIdStart() {
        return courseIdStart;
    }
    public void setCourseIdStart(Integer courseIdStart) {
        this.courseIdStart = courseIdStart;
    }
    public Integer getCourseIdEnd() {
        return courseIdEnd;
    }
    public void setCourseIdEnd(Integer courseIdEnd) {
        this.courseIdEnd = courseIdEnd;
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
    public Integer getStatusStart() {
        return statusStart;
    }
    public void setStatusStart(Integer statusStart) {
        this.statusStart = statusStart;
    }
    public Integer getStatusEnd() {
        return statusEnd;
    }
    public void setStatusEnd(Integer statusEnd) {
        this.statusEnd = statusEnd;
    }
    public Calendar getScheduledTimeStart() {
        return scheduledTimeStart;
    }
    public void setScheduledTimeStart(Calendar scheduledTimeStart) {
        this.scheduledTimeStart = scheduledTimeStart;
    }
    public Calendar getScheduledTimeEnd() {
        return scheduledTimeEnd;
    }
    public void setScheduledTimeEnd(Calendar scheduledTimeEnd) {
        this.scheduledTimeEnd = scheduledTimeEnd;
    }
    public Calendar getNoRefundDateStart() {
        return noRefundDateStart;
    }
    public void setNoRefundDateStart(Calendar noRefundDateStart) {
        this.noRefundDateStart = noRefundDateStart;
    }
    public Calendar getNoRefundDateEnd() {
        return noRefundDateEnd;
    }
    public void setNoRefundDateEnd(Calendar noRefundDateEnd) {
        this.noRefundDateEnd = noRefundDateEnd;
    }
    public Calendar getCashbackDateStart() {
        return cashbackDateStart;
    }
    public void setCashbackDateStart(Calendar cashbackDateStart) {
        this.cashbackDateStart = cashbackDateStart;
    }
    public Calendar getCashbackDateEnd() {
        return cashbackDateEnd;
    }
    public void setCashbackDateEnd(Calendar cashbackDateEnd) {
        this.cashbackDateEnd = cashbackDateEnd;
    }
    public Integer getTypeStart() {
        return typeStart;
    }
    public void setTypeStart(Integer typeStart) {
        this.typeStart = typeStart;
    }
    public Integer getTypeEnd() {
        return typeEnd;
    }
    public void setTypeEnd(Integer typeEnd) {
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
