package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CourseTemplateClassPhotoEntityExt;

public interface CourseTemplateClassPhotoEntityExtMapper {

    public int add(CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt);
    
    public void deleteById(int id);
    
    public void update(CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt);
    
    public int getCount();

    public List<CourseTemplateClassPhotoEntityExt> list(@Param("entity") CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt, @Param("page") PaginationEntity page);
}
