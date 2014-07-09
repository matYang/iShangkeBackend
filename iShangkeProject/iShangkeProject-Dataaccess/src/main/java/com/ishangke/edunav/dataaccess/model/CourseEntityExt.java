package com.ishangke.edunav.dataaccess.model;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.gen.CourseEntity;

public class CourseEntityExt extends CourseEntity {
    private List<CourseTeacherEntityExt> teacherList;

    public List<CourseTeacherEntityExt> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<CourseTeacherEntityExt> teacherList) {
        this.teacherList = teacherList;
    }
}
