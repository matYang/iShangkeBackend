package com.ishangke.edunav.dataaccess.model.gen;

import java.util.Calendar;

public class WithdrawEntity {
    private Integer id;

    private Integer userId;

    private String payeeId;

    private String peyeeName;

    private Integer type;

    private Calendar lastModifyTime;

    private Calendar createTime;

    private Integer enabled;

    private Integer deleted;

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

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId == null ? null : payeeId.trim();
    }

    public String getPeyeeName() {
        return peyeeName;
    }

    public void setPeyeeName(String peyeeName) {
        this.peyeeName = peyeeName == null ? null : peyeeName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}