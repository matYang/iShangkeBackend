package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.CourseTemplateEntity;
import com.ishangke.edunav.dataaccess.model.gen.CourseTemplateEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseTemplateEntityMapper {
    int countByExample(CourseTemplateEntityExample example);

    int deleteByExample(CourseTemplateEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseTemplateEntity record);

    int insertSelective(CourseTemplateEntity record);

    List<CourseTemplateEntity> selectByExample(CourseTemplateEntityExample example);

    CourseTemplateEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseTemplateEntity record, @Param("example") CourseTemplateEntityExample example);

    int updateByExample(@Param("record") CourseTemplateEntity record, @Param("example") CourseTemplateEntityExample example);

    int updateByPrimaryKeySelective(CourseTemplateEntity record);

    int updateByPrimaryKey(CourseTemplateEntity record);
}