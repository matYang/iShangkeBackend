package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.CourseTemplateClassPhotoEntity;
import com.ishangke.edunav.dataaccess.model.gen.CourseTemplateClassPhotoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseTemplateClassPhotoEntityMapper {
    int countByExample(CourseTemplateClassPhotoEntityExample example);

    int deleteByExample(CourseTemplateClassPhotoEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseTemplateClassPhotoEntity record);

    int insertSelective(CourseTemplateClassPhotoEntity record);

    List<CourseTemplateClassPhotoEntity> selectByExample(CourseTemplateClassPhotoEntityExample example);

    CourseTemplateClassPhotoEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseTemplateClassPhotoEntity record, @Param("example") CourseTemplateClassPhotoEntityExample example);

    int updateByExample(@Param("record") CourseTemplateClassPhotoEntity record, @Param("example") CourseTemplateClassPhotoEntityExample example);

    int updateByPrimaryKeySelective(CourseTemplateClassPhotoEntity record);

    int updateByPrimaryKey(CourseTemplateClassPhotoEntity record);
}