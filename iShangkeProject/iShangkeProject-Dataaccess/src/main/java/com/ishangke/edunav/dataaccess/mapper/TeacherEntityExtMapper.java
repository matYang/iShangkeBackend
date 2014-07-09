package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

public interface TeacherEntityExtMapper {

    public int add(TeacherEntityExt teacherEntityEx);
    public void deleteById(int id);
    public void update(TeacherEntityExt teacherEntityEx);
}
