package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.CircleEntity;
import com.ishangke.edunav.dataaccess.model.gen.CircleEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CircleEntityMapper {
    int countByExample(CircleEntityExample example);

    int deleteByExample(CircleEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CircleEntity record);

    int insertSelective(CircleEntity record);

    List<CircleEntity> selectByExample(CircleEntityExample example);

    CircleEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CircleEntity record, @Param("example") CircleEntityExample example);

    int updateByExample(@Param("record") CircleEntity record, @Param("example") CircleEntityExample example);

    int updateByPrimaryKeySelective(CircleEntity record);

    int updateByPrimaryKey(CircleEntity record);
}