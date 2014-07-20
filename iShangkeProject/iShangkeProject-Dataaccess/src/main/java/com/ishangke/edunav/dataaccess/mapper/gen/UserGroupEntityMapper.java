package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.UserGroupEntity;
import com.ishangke.edunav.dataaccess.model.gen.UserGroupEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGroupEntityMapper {
    int countByExample(UserGroupEntityExample example);

    int deleteByExample(UserGroupEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserGroupEntity record);

    int insertSelective(UserGroupEntity record);

    List<UserGroupEntity> selectByExample(UserGroupEntityExample example);

    UserGroupEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserGroupEntity record, @Param("example") UserGroupEntityExample example);

    int updateByExample(@Param("record") UserGroupEntity record, @Param("example") UserGroupEntityExample example);

    int updateByPrimaryKeySelective(UserGroupEntity record);

    int updateByPrimaryKey(UserGroupEntity record);
}