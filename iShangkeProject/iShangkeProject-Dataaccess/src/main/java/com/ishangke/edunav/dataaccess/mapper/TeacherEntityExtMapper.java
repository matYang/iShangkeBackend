package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

public interface TeacherEntityExtMapper {

    public int add(TeacherEntityExt teacherEntityExt);

    public void deleteById(int id);

    public void update(TeacherEntityExt teacherEntityExt);

    public int getCount();

    public List<TeacherEntityExt> list(
            @Param("entity") TeacherEntityExt teacherEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") TeacherEntityExt teacherEntityExt);
    
    public List<TeacherEntityExt> listTeacherByPartnerId(int partnerId);

    public List<TeacherEntityExt> listTeacherByCourseId(int courseId);
    
    public List<TeacherEntityExt> listTeacherByCourseTempleteId(int courseTemplateId);
}
