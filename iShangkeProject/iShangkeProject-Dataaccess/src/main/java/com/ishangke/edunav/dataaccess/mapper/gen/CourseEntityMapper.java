package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.CourseEntity;
import com.ishangke.edunav.dataaccess.model.gen.CourseEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseEntityMapper {
    int countByExample(CourseEntityExample example);

    int deleteByExample(CourseEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseEntity record);

    int insertSelective(CourseEntity record);

    List<CourseEntity> selectByExample(CourseEntityExample example);

    CourseEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseEntity record, @Param("example") CourseEntityExample example);

    int updateByExample(@Param("record") CourseEntity record, @Param("example") CourseEntityExample example);

    int updateByPrimaryKeySelective(CourseEntity record);

    int updateByPrimaryKey(CourseEntity record);
}