package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

public interface TeacherEntityExtMapper {

    public int add(TeacherEntityExt teacherEntityEx);
    
    public void deleteById(int id);
    
    public void update(TeacherEntityExt teacherEntityEx);
    
    public int getCount();

    public List<TeacherEntityExt> list(@Param("entity") TeacherEntityExt teacherEntityEx, @Param("page") PaginationEntity page);
}
