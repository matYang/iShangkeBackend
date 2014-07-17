package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.CourseTemplateClassPhotoEntity;

public class CourseTemplateClassPhotoEntityExt extends CourseTemplateClassPhotoEntity {
    private Set<Integer> idSet;
    private Set<Integer> courseTemplateIdSet;
    private Set<Integer> classPhotoIdSet;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;

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
