package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.ClassPhotoEntity;
import com.ishangke.edunav.dataaccess.model.gen.ClassPhotoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassPhotoEntityMapper {
    int countByExample(ClassPhotoEntityExample example);

    int deleteByExample(ClassPhotoEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassPhotoEntity record);

    int insertSelective(ClassPhotoEntity record);

    List<ClassPhotoEntity> selectByExample(ClassPhotoEntityExample example);

    ClassPhotoEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassPhotoEntity record, @Param("example") ClassPhotoEntityExample example);

    int updateByExample(@Param("record") ClassPhotoEntity record, @Param("example") ClassPhotoEntityExample example);

    int updateByPrimaryKeySelective(ClassPhotoEntity record);

    int updateByPrimaryKey(ClassPhotoEntity record);
}