package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.CourseTeacherEntity;

public class CourseTeacherEntityExt extends CourseTeacherEntity {
    private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;
    private Set<Integer> courseIdSet;
    private Set<Integer> teacherIdSet;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    public Integer getIdStart() {
        return idStart;
    }
    public void setIdStart(Integer idStart) {
        this.idStart = idStart;
    }
    public Integer getIdEnd() {
        return idEnd;
    }
    public void setIdEnd(Integer idEnd) {
        this.idEnd = idEnd;
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
