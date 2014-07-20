package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.GroupEntity;
import com.ishangke.edunav.dataaccess.model.gen.GroupEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupEntityMapper {
    int countByExample(GroupEntityExample example);

    int deleteByExample(GroupEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GroupEntity record);

    int insertSelective(GroupEntity record);

    List<GroupEntity> selectByExample(GroupEntityExample example);

    GroupEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GroupEntity record, @Param("example") GroupEntityExample example);

    int updateByExample(@Param("record") GroupEntity record, @Param("example") GroupEntityExample example);

    int updateByPrimaryKeySelective(GroupEntity record);

    int updateByPrimaryKey(GroupEntity record);
}