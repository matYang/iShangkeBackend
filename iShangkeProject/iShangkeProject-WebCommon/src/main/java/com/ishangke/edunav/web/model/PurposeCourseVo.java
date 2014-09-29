package com.ishangke.edunav.web.model;

import com.ishangke.edunav.web.response.JsonResponse;

public class PurposeCourseVo extends JsonResponse {
    private Integer id;
    private Integer categoryId;
    private String userName;
    private String phone;
    private String remark;
    private Long createTime;
    private Long createTimeStart;
    private Long createTimeEnd;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
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
