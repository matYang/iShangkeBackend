package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.TeacherEntity;
import com.ishangke.edunav.dataaccess.model.gen.TeacherEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherEntityMapper {
    int countByExample(TeacherEntityExample example);

    int deleteByExample(TeacherEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherEntity record);

    int insertSelective(TeacherEntity record);

    List<TeacherEntity> selectByExample(TeacherEntityExample example);

    TeacherEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TeacherEntity record, @Param("example") TeacherEntityExample example);

    int updateByExample(@Param("record") TeacherEntity record, @Param("example") TeacherEntityExample example);

    int updateByPrimaryKeySelective(TeacherEntity record);

    int updateByPrimaryKey(TeacherEntity record);
}