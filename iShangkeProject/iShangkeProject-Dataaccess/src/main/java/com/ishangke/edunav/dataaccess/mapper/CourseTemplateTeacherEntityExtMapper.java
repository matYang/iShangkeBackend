package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CourseTemplateTeacherEntityExt;

public interface CourseTemplateTeacherEntityExtMapper {

    public int add(CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt);

    public void deleteById(int id);

    public void update(
            CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt);

    public int getCount();

    public List<CourseTemplateTeacherEntityExt> list(
            @Param("entity") CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt);
}
