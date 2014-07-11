package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

public interface TeacherEntityExtMapper {

    public int add(TeacherEntityExt teacherEntityEx);
    
    public void deleteById(int id);
    
    public void update(TeacherEntityExt teacherEntityEx);
    
    public int getCount();

    public List<TeacherEntityExt> list(TeacherEntityExt teacherEntityEx);
}
