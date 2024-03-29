package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CourseClassPhotoEntityExt;

public interface CourseClassPhotoEntityExtMapper {

    public int add(CourseClassPhotoEntityExt courseClassPhotoEntityExt);

    public void deleteById(int id);

    public void update(CourseClassPhotoEntityExt courseClassPhotoEntityExt);

    public List<CourseClassPhotoEntityExt> list(
            @Param("entity") CourseClassPhotoEntityExt courseClassPhotoEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") CourseClassPhotoEntityExt courseClassPhotoEntityExt);

    public List<CourseClassPhotoEntityExt> listAll();

    public int getCount();

    public CourseClassPhotoEntityExt getById(int id);

    public void deleteByCourseIdClassPhotoId(@Param("courseId") int courseId, @Param("classPhotoId") int classPhotoId);
}
