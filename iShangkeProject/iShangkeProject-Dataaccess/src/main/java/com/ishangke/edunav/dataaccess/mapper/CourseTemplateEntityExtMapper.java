package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;

public interface CourseTemplateEntityExtMapper {

    public int add(CourseTemplateEntityExt courseTemplateEntityExt);
    public void deleteById(int id);
    public void update(CourseTemplateEntityExt courseTemplateEntityExt);
}
