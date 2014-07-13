package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.CourseTeacherEntity;
import com.ishangke.edunav.dataaccess.model.gen.CourseTeacherEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseTeacherEntityMapper {
    int countByExample(CourseTeacherEntityExample example);

    int deleteByExample(CourseTeacherEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseTeacherEntity record);

    int insertSelective(CourseTeacherEntity record);

    List<CourseTeacherEntity> selectByExample(CourseTeacherEntityExample example);

    CourseTeacherEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseTeacherEntity record, @Param("example") CourseTeacherEntityExample example);

    int updateByExample(@Param("record") CourseTeacherEntity record, @Param("example") CourseTeacherEntityExample example);

    int updateByPrimaryKeySelective(CourseTeacherEntity record);

    int updateByPrimaryKey(CourseTeacherEntity record);
}