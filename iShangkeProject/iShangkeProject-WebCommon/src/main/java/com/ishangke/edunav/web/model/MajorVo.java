package com.ishangke.edunav.web.model;

import com.ishangke.edunav.web.response.JsonResponse;

public class MajorVo extends JsonResponse {
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getSchoolId() {
        return schoolId;
    }
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    private Integer schoolId;
    private String value;
    private String name;
    private Long lastModifyTime;
    private Long createTime;
    private Integer enabled;

}
