package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.CourseTemplateTeacherEntity;
import com.ishangke.edunav.dataaccess.model.gen.CourseTemplateTeacherEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseTemplateTeacherEntityMapper {
    int countByExample(CourseTemplateTeacherEntityExample example);

    int deleteByExample(CourseTemplateTeacherEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseTemplateTeacherEntity record);

    int insertSelective(CourseTemplateTeacherEntity record);

    List<CourseTemplateTeacherEntity> selectByExample(CourseTemplateTeacherEntityExample example);

    CourseTemplateTeacherEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseTemplateTeacherEntity record, @Param("example") CourseTemplateTeacherEntityExample example);

    int updateByExample(@Param("record") CourseTemplateTeacherEntity record, @Param("example") CourseTemplateTeacherEntityExample example);

    int updateByPrimaryKeySelective(CourseTemplateTeacherEntity record);

    int updateByPrimaryKey(CourseTemplateTeacherEntity record);
}