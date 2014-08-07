package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.BookingEntity;

public class BookingEntityExt extends BookingEntity {
    private Set<Integer> idSet;
    private Set<Integer> courseIdSet;
    private Set<Integer> courseTemplateIdSet;
    private Set<Integer> userIdSet;
    private Set<Integer> statusSet;
    private Calendar scheduledTimeStart;
    private Calendar scheduledTimeEnd;
    private Calendar noRefundDateStart;
    private Calendar noRefundDateEnd;
    private Calendar cashbackDateStart;
    private Calendar cashbackDateEnd;
    private Double priceStart;
    private Double priceEnd;
    private Set<Integer> typeSet;
    private Double cashbackAmountStart;
    private Double cashbackAmountEnd;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    private Set<Integer> partnerIdSet;
    
    private CourseEntityExt course;
    
    public Set<Integer> getPartnerIdSet() {
        return partnerIdSet;
    }

    public void setPartnerIdSet(Set<Integer> partnerIdSet) {
        this.partnerIdSet = partnerIdSet;
    }

    public Set<Integer> getIdSet() {
        return idSet;
    }

    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }

    public Set<Integer> getCourseIdSet() {
        return courseIdSet;
    }

    public void setCourseIdSet(Set<Integer> courseIdSet) {
        this.courseIdSet = courseIdSet;
    }

    public Set<Integer> getUserIdSet() {
        return userIdSet;
    }

    public void setUserIdSet(Set<Integer> userIdSet) {
        this.userIdSet = userIdSet;
    }

    public Set<Integer> getCourseTemplateIdSet() {
        return courseTemplateIdSet;
    }

    public void setCourseTemplateIdSet(Set<Integer> courseTemplateIdSet) {
        this.courseTemplateIdSet = courseTemplateIdSet;
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

    public Set<Integer> getStatusSet() {
        return statusSet;
    }

    public void setStatusSet(Set<Integer> statusSet) {
        this.statusSet = statusSet;
    }

    public Double getPriceStart() {
        return priceStart;
    }

    public void setPriceStart(Double priceStart) {
        this.priceStart = priceStart;
    }

    public Double getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(Double priceEnd) {
        this.priceEnd = priceEnd;
    }

    public Set<Integer> getTypeSet() {
        return typeSet;
    }

    public void setTypeSet(Set<Integer> typeSet) {
        this.typeSet = typeSet;
    }

    public CourseEntityExt getCourse() {
        return course;
    }

    public void setCourse(CourseEntityExt course) {
        this.course = course;
    }

}
