package com.ishangke.edunav.web.model;

import java.util.Set;

import com.ishangke.edunav.web.response.JsonResponse;

public class GroupBuyBookingVo extends JsonResponse {
    private Integer id;
    private Long createTime;
    private Integer status;
    private Double groupBuyPrice;
    private Integer groupBuyActivityId;
    private Integer userId;
    private Set<Integer> idSet;
    private Long createTimeStart;
    private Long createTimeEnd;
    private Set<Integer> statusSet;
    private Double groupBuyPriceStart;
    private Double groupBuyPriceEnd;
    private Set<Integer> groupBuyActivityIdSet;
    private Set<Integer> userIdSet;
    private GroupBuyActivityVo groupBuyActivity;
    private UserVo user;
    private String reference;
    private String number;
    
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Double getGroupBuyPrice() {
        return groupBuyPrice;
    }
    public void setGroupBuyPrice(Double groupBuyPrice) {
        this.groupBuyPrice = groupBuyPrice;
    }
    public Integer getGroupBuyActivityId() {
        return groupBuyActivityId;
    }
    public void setGroupBuyActivityId(Integer groupBuyActivityId) {
        this.groupBuyActivityId = groupBuyActivityId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Set<Integer> getIdSet() {
        return idSet;
    }
    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
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
    public Set<Integer> getStatusSet() {
        return statusSet;
    }
    public void setStatusSet(Set<Integer> statusSet) {
        this.statusSet = statusSet;
    }
    public Double getGroupBuyPriceStart() {
        return groupBuyPriceStart;
    }
    public void setGroupBuyPriceStart(Double groupBuyPriceStart) {
        this.groupBuyPriceStart = groupBuyPriceStart;
    }
    public Double getGroupBuyPriceEnd() {
        return groupBuyPriceEnd;
    }
    public void setGroupBuyPriceEnd(Double groupBuyPriceEnd) {
        this.groupBuyPriceEnd = groupBuyPriceEnd;
    }
    public Set<Integer> getGroupBuyActivityIdSet() {
        return groupBuyActivityIdSet;
    }
    public void setGroupBuyActivityIdSet(Set<Integer> groupBuyActivityIdSet) {
        this.groupBuyActivityIdSet = groupBuyActivityIdSet;
    }
    public Set<Integer> getUserIdSet() {
        return userIdSet;
    }
    public void setUserIdSet(Set<Integer> userIdSet) {
        this.userIdSet = userIdSet;
    }
    public GroupBuyActivityVo getGroupBuyActivity() {
        return groupBuyActivity;
    }
    public void setGroupBuyActivity(GroupBuyActivityVo groupBuyActivity) {
        this.groupBuyActivity = groupBuyActivity;
    }
    public UserVo getUser() {
        return user;
    }
    public void setUser(UserVo user) {
        this.user = user;
    }
}
