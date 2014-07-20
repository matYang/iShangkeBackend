package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.ActivityEntity;
import com.ishangke.edunav.dataaccess.model.gen.ActivityEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityEntityMapper {
    int countByExample(ActivityEntityExample example);

    int deleteByExample(ActivityEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivityEntity record);

    int insertSelective(ActivityEntity record);

    List<ActivityEntity> selectByExample(ActivityEntityExample example);

    ActivityEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivityEntity record, @Param("example") ActivityEntityExample example);

    int updateByExample(@Param("record") ActivityEntity record, @Param("example") ActivityEntityExample example);

    int updateByPrimaryKeySelective(ActivityEntity record);

    int updateByPrimaryKey(ActivityEntity record);
}