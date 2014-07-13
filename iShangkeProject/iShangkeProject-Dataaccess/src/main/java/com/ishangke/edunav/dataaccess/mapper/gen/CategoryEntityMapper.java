package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.CategoryEntity;
import com.ishangke.edunav.dataaccess.model.gen.CategoryEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryEntityMapper {
    int countByExample(CategoryEntityExample example);

    int deleteByExample(CategoryEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryEntity record);

    int insertSelective(CategoryEntity record);

    List<CategoryEntity> selectByExample(CategoryEntityExample example);

    CategoryEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CategoryEntity record, @Param("example") CategoryEntityExample example);

    int updateByExample(@Param("record") CategoryEntity record, @Param("example") CategoryEntityExample example);

    int updateByPrimaryKeySelective(CategoryEntity record);

    int updateByPrimaryKey(CategoryEntity record);
}