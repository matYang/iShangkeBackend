package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.CourseCommentEntity;
import com.ishangke.edunav.dataaccess.model.gen.CourseCommentEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseCommentEntityMapper {
    int countByExample(CourseCommentEntityExample example);

    int deleteByExample(CourseCommentEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseCommentEntity record);

    int insertSelective(CourseCommentEntity record);

    List<CourseCommentEntity> selectByExample(CourseCommentEntityExample example);

    CourseCommentEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseCommentEntity record, @Param("example") CourseCommentEntityExample example);

    int updateByExample(@Param("record") CourseCommentEntity record, @Param("example") CourseCommentEntityExample example);

    int updateByPrimaryKeySelective(CourseCommentEntity record);

    int updateByPrimaryKey(CourseCommentEntity record);
}