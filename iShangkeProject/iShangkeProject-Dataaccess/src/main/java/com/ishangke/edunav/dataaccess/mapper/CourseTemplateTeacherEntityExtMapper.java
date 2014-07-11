package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.CourseTemplateTeacherEntityExt;

public interface CourseTemplateTeacherEntityExtMapper {

    public int add(CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt);
    
    public void deleteById(int id);
    
    public void update(CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt);
    
    public int getCount();

    public List<CourseTemplateTeacherEntityExt> list(CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt);
}
