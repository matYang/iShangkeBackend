package com.ishangke.edunav.web.user.model;

import java.util.Calendar;
import java.util.Set;

public class CourseTemplateTeacherVo {
    private Integer id;

    private Integer courseTemplateId;

    private Integer teacherId;

    private Calendar createTime;
    private Set<Integer> idSet;
    private Set<Integer> courseTemplateIdSet;
    private Set<Integer> teacherIdSet;
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
    public Integer getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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
    public Set<Integer> getTeacherIdSet() {
        return teacherIdSet;
    }
    public void setTeacherIdSet(Set<Integer> teacherIdSet) {
        this.teacherIdSet = teacherIdSet;
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
