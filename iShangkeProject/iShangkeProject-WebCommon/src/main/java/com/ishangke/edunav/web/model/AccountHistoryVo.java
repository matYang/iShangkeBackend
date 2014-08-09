package com.ishangke.edunav.web.model;

import java.util.Set;

import com.ishangke.edunav.web.response.JsonResponse;

public class AccountHistoryVo extends JsonResponse {
    private Integer id;
    private Integer userId;
    private Integer withdrawId;
    private Double charge;
    private Integer type;
    private Long createTime;
    private String remark;
    private Set<Integer> idSet;
    private Set<Integer> userIdSet;
    private Set<Integer> withdrawIdSet;
    private Double chargeStart;
    private Double chargeEnd;
    private Set<Integer> typeSet;
    private Long createTimeStart;
    private Long createTimeEnd;
    private Integer operation;
    private Set<Integer> operationSet;

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

    public Integer getWithdrawId() {
        return withdrawId;
    }

    public void setWithdrawId(Integer withdrawId) {
        this.withdrawId = withdrawId;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<Integer> getIdSet() {
        return idSet;
    }

    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }

    public Set<Integer> getUserIdSet() {
        return userIdSet;
    }

    public void setUserIdSet(Set<Integer> userIdSet) {
        this.userIdSet = userIdSet;
    }

    public Set<Integer> getWithdrawIdSet() {
        return withdrawIdSet;
    }

    public void setWithdrawIdSet(Set<Integer> withdrawIdSet) {
        this.withdrawIdSet = withdrawIdSet;
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

    public Set<Integer> getTypeSet() {
        return typeSet;
    }

    public void setTypeSet(Set<Integer> typeSet) {
        this.typeSet = typeSet;
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

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public Set<Integer> getOperationSet() {
        return operationSet;
    }

    public void setOperationSet(Set<Integer> operationSet) {
        this.operationSet = operationSet;
    }

}
