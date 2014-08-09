package com.ishangke.edunav.web.model;

import java.util.Set;

import com.ishangke.edunav.web.response.JsonResponse;

public class CourseTemplateClassPhotoVo extends JsonResponse {
    private Integer id;

    private Integer courseTemplateId;

    private Integer classPhotoId;

    private Long createTime;
    private Set<Integer> idSet;
    private Set<Integer> courseTemplateIdSet;
    private Set<Integer> classPhotoIdSet;
    private Long createTimeStart;
    private Long createTimeEnd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseTemplateId() {
        return courseTemplateId;
    }

    public void setCourseTemplateId(Integer courseTemplateId) {
        this.courseTemplateId = courseTemplateId;
    }

    public Integer getClassPhotoId() {
        return classPhotoId;
    }

    public void setClassPhotoId(Integer classPhotoId) {
        this.classPhotoId = classPhotoId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Set<Integer> getIdSet() {
        return idSet;
    }

    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }

    public Set<Integer> getCourseTemplateIdSet() {
        return courseTemplateIdSet;
    }

    public void setCourseTemplateIdSet(Set<Integer> courseTemplateIdSet) {
        this.courseTemplateIdSet = courseTemplateIdSet;
    }

    public Set<Integer> getClassPhotoIdSet() {
        return classPhotoIdSet;
    }

    public void setClassPhotoIdSet(Set<Integer> classPhotoIdSet) {
        this.classPhotoIdSet = classPhotoIdSet;
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
