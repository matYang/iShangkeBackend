package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.LocationEntity;
import com.ishangke.edunav.dataaccess.model.gen.LocationEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LocationEntityMapper {
    int countByExample(LocationEntityExample example);

    int deleteByExample(LocationEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LocationEntity record);

    int insertSelective(LocationEntity record);

    List<LocationEntity> selectByExample(LocationEntityExample example);

    LocationEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LocationEntity record, @Param("example") LocationEntityExample example);

    int updateByExample(@Param("record") LocationEntity record, @Param("example") LocationEntityExample example);

    int updateByPrimaryKeySelective(LocationEntity record);

    int updateByPrimaryKey(LocationEntity record);
}