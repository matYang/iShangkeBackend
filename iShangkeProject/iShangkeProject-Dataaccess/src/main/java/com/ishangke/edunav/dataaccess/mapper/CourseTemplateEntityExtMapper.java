package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;

public interface CourseTemplateEntityExtMapper {

    public int add(CourseTemplateEntityExt courseTemplateEntityExt);

    public void deleteById(int id);

    public void update(CourseTemplateEntityExt courseTemplateEntityExt);

    public List<CourseTemplateEntityExt> list(
            @Param("entity") CourseTemplateEntityExt courseTemplateEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") CourseTemplateEntityExt courseTemplateEntityExt);

    public List<CourseTemplateEntityExt> listAll();

    public int getCount();
    
    public CourseTemplateEntityExt getInfoById(int id);
}
