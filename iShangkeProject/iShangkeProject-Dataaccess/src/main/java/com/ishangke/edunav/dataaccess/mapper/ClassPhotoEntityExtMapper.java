package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;

public interface ClassPhotoEntityExtMapper {

    public int add(ClassPhotoEntityExt classphotoEntityExt);

    public void deleteById(int id);

    public void update(ClassPhotoEntityExt classphotoEntityExt);

    public int getCount();

    public List<ClassPhotoEntityExt> list(
            @Param("entity") ClassPhotoEntityExt classphotoEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") ClassPhotoEntityExt classphotoEntityExt);
    
    public List<ClassPhotoEntityExt> listClassPhotoByPartnerId(int partnerId);
    
    public List<ClassPhotoEntityExt> listClassPhotoByCourseId(int courseId);
    
    public List<ClassPhotoEntityExt> listClassPhotoByCourseTempleteId(int courseTemplateId);
}
