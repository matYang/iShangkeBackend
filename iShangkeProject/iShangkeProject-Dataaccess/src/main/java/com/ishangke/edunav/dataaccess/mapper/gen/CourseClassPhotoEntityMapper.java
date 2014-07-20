package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.CourseClassPhotoEntity;
import com.ishangke.edunav.dataaccess.model.gen.CourseClassPhotoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseClassPhotoEntityMapper {
    int countByExample(CourseClassPhotoEntityExample example);

    int deleteByExample(CourseClassPhotoEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseClassPhotoEntity record);

    int insertSelective(CourseClassPhotoEntity record);

    List<CourseClassPhotoEntity> selectByExample(CourseClassPhotoEntityExample example);

    CourseClassPhotoEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseClassPhotoEntity record, @Param("example") CourseClassPhotoEntityExample example);

    int updateByExample(@Param("record") CourseClassPhotoEntity record, @Param("example") CourseClassPhotoEntityExample example);

    int updateByPrimaryKeySelective(CourseClassPhotoEntity record);

    int updateByPrimaryKey(CourseClassPhotoEntity record);
}