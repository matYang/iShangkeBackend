package com.ishangke.edunav.web.model;

import java.util.Set;

import com.ishangke.edunav.web.response.JsonResponse;

public class OrderHistoryVo extends JsonResponse {
    private Integer id;

    private Integer orderId;

    private Integer userId;

    private Integer optName;

    private String remark;

    private Integer preStatus;

    private Integer postStatus;

    private Integer normal;

    private Long createTime;

    private Integer enabled;
    private Set<Integer> idSet;
    private Set<Integer> orderIdSet;
    private Set<Integer> userIdSet;
    private Set<Integer> optNameSet;
    private Set<Integer> preStatusSet;
    private Set<Integer> postStatusSet;
    private Set<Integer> normalSet;
    private Long createTimeStart;
    private Long createTimeEnd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOptName() {
        return optName;
    }

    public void setOptName(Integer optName) {
        this.optName = optName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(Integer preStatus) {
        this.preStatus = preStatus;
    }

    public Integer getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    public Integer getNormal() {
        return normal;
    }

    public void setNormal(Integer normal) {
        this.normal = normal;
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

    public Set<Integer> getOrderIdSet() {
        return orderIdSet;
    }

    public void setOrderIdSet(Set<Integer> orderIdSet) {
        this.orderIdSet = orderIdSet;
    }

    public Set<Integer> getUserIdSet() {
        return userIdSet;
    }

    public void setUserIdSet(Set<Integer> userIdSet) {
        this.userIdSet = userIdSet;
    }

    public Set<Integer> getOptNameSet() {
        return optNameSet;
    }

    public void setOptNameSet(Set<Integer> optNameSet) {
        this.optNameSet = optNameSet;
    }

    public Set<Integer> getPreStatusSet() {
        return preStatusSet;
    }

    public void setPreStatusSet(Set<Integer> preStatusSet) {
        this.preStatusSet = preStatusSet;
    }

    public Set<Integer> getPostStatusSet() {
        return postStatusSet;
    }

    public void setPostStatusSet(Set<Integer> postStatusSet) {
        this.postStatusSet = postStatusSet;
    }

    public Set<Integer> getNormalSet() {
        return normalSet;
    }

    public void setNormalSet(Set<Integer> normalSet) {
        this.normalSet = normalSet;
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

}
