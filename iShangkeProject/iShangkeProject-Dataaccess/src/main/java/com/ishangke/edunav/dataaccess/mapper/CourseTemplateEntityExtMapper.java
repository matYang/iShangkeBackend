package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;

public interface CourseTemplateEntityExtMapper {

    public int add(CourseTemplateEntityExt courseTemplateEntityExt);
    
    public void deleteById(int id);
    
    public void update(CourseTemplateEntityExt courseTemplateEntityExt);
    
    public int getCount();

    public List<CourseTemplateEntityExt> list(CourseTemplateEntityExt courseTemplateEntityExt);
}
