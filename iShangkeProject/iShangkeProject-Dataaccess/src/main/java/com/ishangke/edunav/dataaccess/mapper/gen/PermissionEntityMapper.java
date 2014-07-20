package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.PermissionEntity;
import com.ishangke.edunav.dataaccess.model.gen.PermissionEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionEntityMapper {
    int countByExample(PermissionEntityExample example);

    int deleteByExample(PermissionEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PermissionEntity record);

    int insertSelective(PermissionEntity record);

    List<PermissionEntity> selectByExample(PermissionEntityExample example);

    PermissionEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PermissionEntity record, @Param("example") PermissionEntityExample example);

    int updateByExample(@Param("record") PermissionEntity record, @Param("example") PermissionEntityExample example);

    int updateByPrimaryKeySelective(PermissionEntity record);

    int updateByPrimaryKey(PermissionEntity record);
}