package com.ishangke.edunav.web.model;

import java.util.List;
import java.util.Set;

import com.ishangke.edunav.web.common.ActionVo;
import com.ishangke.edunav.web.response.JsonResponse;

public class BookingVo extends JsonResponse {
    private Integer id;

    private Integer userId;

    private Integer courseId;

    private Integer courseTemplateId;

    private String reference;

    private String name;

    private String phone;

    private String email;

    private Integer status;

    private Long scheduledTime;

    private Long noRefundDate;

    private Long cashbackDate;
    private Double price;
    private Integer type;

    private String note;

    private Double cashbackAmount;

    private Long lastModifyTime;

    private Long createTime;

    private Integer enabled;
    private Set<Integer> idSet;
    private Set<Integer> courseIdSet;
    private Set<Integer> courseTemplateIdSet;
    private Set<Integer> userIdSet;
    private Set<Integer> statusSet;
    private Long scheduledTimeStart;
    private Long scheduledTimeEnd;
    private Long noRefundDateStart;
    private Long noRefundDateEnd;
    private Long cashbackDateStart;
    private Long cashbackDateEnd;
    private Set<Integer> typeSet;
    private Double cashbackAmountStart;
    private Double cashbackAmountEnd;
    private Long lastModifyTimeStart;
    private Long lastModifyTimeEnd;
    private Long createTimeStart;
    private Long createTimeEnd;
    private List<ActionVo> actionList;
    private Double priceStart;
    private Double priceEnd;
    private Integer partnerId;
    private Set<Integer> partnerIdSet;

    private CourseVo course;
    
    private Double realCashbackAmount;
    
    public Double getRealCashbackAmount() {
        return realCashbackAmount;
    }

    public void setRealCashbackAmount(Double realCashbackAmount) {
        this.realCashbackAmount = realCashbackAmount;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public Set<Integer> getPartnerIdSet() {
        return partnerIdSet;
    }

    public void setPartnerIdSet(Set<Integer> partnerIdSet) {
        this.partnerIdSet = partnerIdSet;
    }

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

    public String getEmail() {
        return email;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Long getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Long scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public Long getNoRefundDate() {
        return noRefundDate;
    }

    public void setNoRefundDate(Long noRefundDate) {
        this.noRefundDate = noRefundDate;
    }

    public Long getCashbackDate() {
        return cashbackDate;
    }

    public void setCashbackDate(Long cashbackDate) {
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

    public Long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
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

    public Long getScheduledTimeStart() {
        return scheduledTimeStart;
    }

    public void setScheduledTimeStart(Long scheduledTimeStart) {
        this.scheduledTimeStart = scheduledTimeStart;
    }

    public Long getScheduledTimeEnd() {
        return scheduledTimeEnd;
    }

    public void setScheduledTimeEnd(Long scheduledTimeEnd) {
        this.scheduledTimeEnd = scheduledTimeEnd;
    }

    public Long getNoRefundDateStart() {
        return noRefundDateStart;
    }

    public void setNoRefundDateStart(Long noRefundDateStart) {
        this.noRefundDateStart = noRefundDateStart;
    }

    public Long getNoRefundDateEnd() {
        return noRefundDateEnd;
    }

    public void setNoRefundDateEnd(Long noRefundDateEnd) {
        this.noRefundDateEnd = noRefundDateEnd;
    }

    public Long getCashbackDateStart() {
        return cashbackDateStart;
    }

    public void setCashbackDateStart(Long cashbackDateStart) {
        this.cashbackDateStart = cashbackDateStart;
    }

    public Long getCashbackDateEnd() {
        return cashbackDateEnd;
    }

    public void setCashbackDateEnd(Long cashbackDateEnd) {
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

    public Long getLastModifyTimeStart() {
        return lastModifyTimeStart;
    }

    public void setLastModifyTimeStart(Long lastModifyTimeStart) {
        this.lastModifyTimeStart = lastModifyTimeStart;
    }

    public Long getLastModifyTimeEnd() {
        return lastModifyTimeEnd;
    }

    public void setLastModifyTimeEnd(Long lastModifyTimeEnd) {
        this.lastModifyTimeEnd = lastModifyTimeEnd;
    }

    public Long getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Long createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Long getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Long createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public CourseVo getCourse() {
        return course;
    }

    public void setCourse(CourseVo course) {
        this.course = course;
    }

}
