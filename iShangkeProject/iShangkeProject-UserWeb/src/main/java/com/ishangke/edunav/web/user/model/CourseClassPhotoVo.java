package com.ishangke.edunav.web.user.model;

import java.util.Calendar;
import java.util.Set;

public class CourseClassPhotoVo {
    private Integer id;

    private Integer courseId;

    private Integer classPhotoId;

    private Calendar createTime;
    private Set<Integer> idSet;
    private Set<Integer> courseIdSet;
    private Set<Integer> classPhotoIdSet;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCourseId() {
        return courseId;
    }
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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
    public Set<Integer> getCourseIdSet() {
        return courseIdSet;
    }
    public void setCourseIdSet(Set<Integer> courseIdSet) {
        this.courseIdSet = courseIdSet;
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
