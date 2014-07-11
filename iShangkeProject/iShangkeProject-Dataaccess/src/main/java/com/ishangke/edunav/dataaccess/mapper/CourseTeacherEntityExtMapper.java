package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.CourseTeacherEntityExt;

public interface CourseTeacherEntityExtMapper {

    public int add(CourseTeacherEntityExt courseTeacherEntityExt);
    
    public void deleteById(int id);
    
    public void update(CourseTeacherEntityExt courseTeacherEntityExt);
    
    public int getCount();

    public List<CourseTeacherEntityExt> list(CourseTeacherEntityExt courseTeacherEntityExt);
}
