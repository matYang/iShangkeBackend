package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.SpreadEntity;
import com.ishangke.edunav.dataaccess.model.gen.SpreadEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpreadEntityMapper {
    int countByExample(SpreadEntityExample example);

    int deleteByExample(SpreadEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SpreadEntity record);

    int insertSelective(SpreadEntity record);

    List<SpreadEntity> selectByExample(SpreadEntityExample example);

    SpreadEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SpreadEntity record, @Param("example") SpreadEntityExample example);

    int updateByExample(@Param("record") SpreadEntity record, @Param("example") SpreadEntityExample example);

    int updateByPrimaryKeySelective(SpreadEntity record);

    int updateByPrimaryKey(SpreadEntity record);
}