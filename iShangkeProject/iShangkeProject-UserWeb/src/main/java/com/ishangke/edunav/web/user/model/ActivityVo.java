package com.ishangke.edunav.web.user.model;

import java.util.Calendar;
import java.util.Set;

public class ActivityVo {
    private Integer id;
    private String name;
    private Integer partnerId;
    private Integer courseId;
    private String remark;
    private Calendar startTime;
    private Calendar endTime;
    private Integer status;
    private Calendar lastModifyTime;
    private Calendar createTime;
    private Integer enabled;
    private Set<Integer> idSet;
    private Set<Integer> partnerIdSet;
    private Set<Integer> courseIdSet;
    private Calendar startTimeStart;
    private Calendar startTimeEnd;
    private Calendar endTimeStart;
    private Calendar endTimeEnd;
    private Set<Integer> statusSet;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPartnerId() {
        return partnerId;
    }
    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }
    public Integer getCourseId() {
        return courseId;
    }
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Calendar getStartTime() {
        return startTime;
    }
    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }
    public Calendar getEndTime() {
        return endTime;
    }
    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
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
    public Set<Integer> getStatusSet() {
        return statusSet;
    }
    public void setStatusSet(Set<Integer> statusSet) {
        this.statusSet = statusSet;
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
