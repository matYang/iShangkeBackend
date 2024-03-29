package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CourseTeacherEntityExt;

public interface CourseTeacherEntityExtMapper {

    public int add(CourseTeacherEntityExt courseTeacherEntityExt);

    public void deleteById(int id);

    public void update(CourseTeacherEntityExt courseTeacherEntityExt);

    public List<CourseTeacherEntityExt> list(
            @Param("entity") CourseTeacherEntityExt courseTeacherEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") CourseTeacherEntityExt courseTeacherEntityExt);

    public List<CourseTeacherEntityExt> listAll();

    public int getCount();

    public CourseTeacherEntityExt getById(int id);

    public void deleteByCourseIdTeacherId(@Param("courseId") int courseId, @Param("teacherId") int teacherId);
}
