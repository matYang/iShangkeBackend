package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.UserLocationEntity;
import com.ishangke.edunav.dataaccess.model.gen.UserLocationEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLocationEntityMapper {
    int countByExample(UserLocationEntityExample example);

    int deleteByExample(UserLocationEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserLocationEntity record);

    int insertSelective(UserLocationEntity record);

    List<UserLocationEntity> selectByExample(UserLocationEntityExample example);

    UserLocationEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserLocationEntity record, @Param("example") UserLocationEntityExample example);

    int updateByExample(@Param("record") UserLocationEntity record, @Param("example") UserLocationEntityExample example);

    int updateByPrimaryKeySelective(UserLocationEntity record);

    int updateByPrimaryKey(UserLocationEntity record);
}