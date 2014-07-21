package com.ishangke.edunav.web.model;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import com.ishangke.edunav.web.common.ActionVo;

public class BookingVo {
    private Integer id;

    private Integer userId;

    private Integer courseId;

    private Integer courseTemplateId;

    private String reference;

    private String name;

    private String phone;

    private String email;

    private Integer status;

    private Calendar scheduledTime;

    private Calendar noRefundDate;

    private Calendar cashbackDate;

    private Integer type;

    private String note;

    private Double cashbackAmount;

    private Calendar lastModifyTime;

    private Calendar createTime;

    private Integer enabled;
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
    private Set<Integer> typeSet;
    private Double cashbackAmountStart;
    private Double cashbackAmountEnd;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    private List<ActionVo> actionList;
    
    public List<ActionVo> getActionList() {
        return actionList;
    }
    public void setActionList(List<ActionVo> actionList) {
        this.actionList = actionList;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getCourseId() {
        return courseId;
    }
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public Integer getCourseTemplateId() {
        return courseTemplateId;
    }
    public void setCourseTemplateId(Integer courseTemplateId) {
        this.courseTemplateId = courseTemplateId;
    }
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Calendar getScheduledTime() {
        return scheduledTime;
    }
    public void setScheduledTime(Calendar scheduledTime) {
        this.scheduledTime = scheduledTime;
    }
    public Calendar getNoRefundDate() {
        return noRefundDate;
    }
    public void setNoRefundDate(Calendar noRefundDate) {
        this.noRefundDate = noRefundDate;
    }
    public Calendar getCashbackDate() {
        return cashbackDate;
    }
    public void setCashbackDate(Calendar cashbackDate) {
        this.cashbackDate = cashbackDate;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public Double getCashbackAmount() {
        return cashbackAmount;
    }
    public void setCashbackAmount(Double cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
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
    public Set<Integer> getCourseIdSet() {
        return courseIdSet;
    }
    public void setCourseIdSet(Set<Integer> courseIdSet) {
        this.courseIdSet = courseIdSet;
    }
    public Set<Integer> getCourseTemplateIdSet() {
        return courseTemplateIdSet;
    }
    public void setCourseTemplateIdSet(Set<Integer> courseTemplateIdSet) {
        this.courseTemplateIdSet = courseTemplateIdSet;
    }
    public Set<Integer> getUserIdSet() {
        return userIdSet;
    }
    public void setUserIdSet(Set<Integer> userIdSet) {
        this.userIdSet = userIdSet;
    }
    public Set<Integer> getStatusSet() {
        return statusSet;
    }
    public void setStatusSet(Set<Integer> statusSet) {
        this.statusSet = statusSet;
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
    public Set<Integer> getTypeSet() {
        return typeSet;
    }
    public void setTypeSet(Set<Integer> typeSet) {
        this.typeSet = typeSet;
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
