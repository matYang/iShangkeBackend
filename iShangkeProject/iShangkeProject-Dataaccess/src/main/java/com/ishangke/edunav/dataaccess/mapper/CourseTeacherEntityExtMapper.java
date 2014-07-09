package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.CourseTeacherEntityExt;

public interface CourseTeacherEntityExtMapper {

    public int add(CourseTeacherEntityExt courseTeacherEntityExt);
    public void deleteById(int id);
    public void update(CourseTeacherEntityExt courseTeacherEntityExt);
}
