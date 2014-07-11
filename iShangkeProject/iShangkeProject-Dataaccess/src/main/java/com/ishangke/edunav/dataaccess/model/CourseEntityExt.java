package com.ishangke.edunav.dataaccess.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.CourseEntity;

public class CourseEntityExt extends CourseEntity {
    private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;
    private Date lastModifyTimeBefore;
    private Date lastModifyTimeAfter;
    private Date createTimeBefore;
    private Date createTimeAfter;
    private List<TeacherEntityExt> teacherList;

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

    public Date getLastModifyTimeBefore() {
        return lastModifyTimeBefore;
    }

    public void setLastModifyTimeBefore(Date lastModifyTimeBefore) {
        this.lastModifyTimeBefore = lastModifyTimeBefore;
    }

    public Date getLastModifyTimeAfter() {
        return lastModifyTimeAfter;
    }

    public void setLastModifyTimeAfter(Date lastModifyTimeAfter) {
        this.lastModifyTimeAfter = lastModifyTimeAfter;
    }

    public Date getCreateTimeBefore() {
        return createTimeBefore;
    }

    public void setCreateTimeBefore(Date createTimeBefore) {
        this.createTimeBefore = createTimeBefore;
    }

    public Date getCreateTimeAfter() {
        return createTimeAfter;
    }

    public void setCreateTimeAfter(Date createTimeAfter) {
        this.createTimeAfter = createTimeAfter;
    }

    public List<TeacherEntityExt> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<TeacherEntityExt> teacherList) {
        this.teacherList = teacherList;
    }
}
