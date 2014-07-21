package com.ishangke.edunav.web.model;

import java.util.Calendar;
import java.util.Set;

public class CourseTemplateClassPhotoVo {
    private Integer id;

    private Integer courseTemplateId;

    private Integer classPhotoId;

    private Calendar createTime;
    private Set<Integer> idSet;
    private Set<Integer> courseTemplateIdSet;
    private Set<Integer> classPhotoIdSet;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
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
    public Calendar getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Calendar createTime) {
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
