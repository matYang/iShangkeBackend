package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.CourseTemplateTeacherEntityExt;

public interface CourseTemplateTeacherEntityExtMapper {

    public int add(CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt);
    public void deleteById(int id);
    public void update(CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt);
}
