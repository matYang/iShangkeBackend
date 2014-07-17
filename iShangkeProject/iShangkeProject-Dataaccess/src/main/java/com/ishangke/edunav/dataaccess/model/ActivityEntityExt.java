package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.ActivityEntity;

public class ActivityEntityExt extends ActivityEntity {

    private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;
    private Integer partnerIdStart;
    private Integer partnerIdEnd;  
    private Set<Integer> partnerIdSet;
    private Integer courseIdStart;
    private Integer courseIdEnd;
    private Set<Integer> courseIdSet;
    private Calendar startTimeStart;
    private Calendar startTimeEnd;
    private Calendar endTimeStart;
    private Calendar endTimeEnd;
    private Integer statusStart;
    private Integer statusEnd;
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
    public Set<Integer> getPartnerIdSet() {
        return partnerIdSet;
    }
    public void setPartnerIdSet(Set<Integer> partnerIdSet) {
        this.partnerIdSet = partnerIdSet;
    }
    public Set<Integer> getCourseIdSet() {
        return courseIdSet;
    }
    public void setCourseIdSet(Set<Integer> courseIdSet) {
        this.courseIdSet = courseIdSet;
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
    public Integer getPartnerIdStart() {
        return partnerIdStart;
    }
    public void setPartnerIdStart(Integer partnerIdStart) {
        this.partnerIdStart = partnerIdStart;
    }
    public Integer getPartnerIdEnd() {
        return partnerIdEnd;
    }
    public void setPartnerIdEnd(Integer partnerIdEnd) {
        this.partnerIdEnd = partnerIdEnd;
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
    public Calendar getStartTimeStart() {
        return startTimeStart;
    }
    public void setStartTimeStart(Calendar startTimeStart) {
        this.startTimeStart = startTimeStart;
    }
    public Calendar getStartTimeEnd() {
        return startTimeEnd;
    }
    public void setStartTimeEnd(Calendar startTimeEnd) {
        this.startTimeEnd = startTimeEnd;
    }
    public Calendar getEndTimeStart() {
        return endTimeStart;
    }
    public void setEndTimeStart(Calendar endTimeStart) {
        this.endTimeStart = endTimeStart;
    }
    public Calendar getEndTimeEnd() {
        return endTimeEnd;
    }
    public void setEndTimeEnd(Calendar endTimeEnd) {
        this.endTimeEnd = endTimeEnd;
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
