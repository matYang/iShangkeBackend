package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.RolePermissionEntity;
import com.ishangke.edunav.dataaccess.model.gen.RolePermissionEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermissionEntityMapper {
    int countByExample(RolePermissionEntityExample example);

    int deleteByExample(RolePermissionEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolePermissionEntity record);

    int insertSelective(RolePermissionEntity record);

    List<RolePermissionEntity> selectByExample(RolePermissionEntityExample example);

    RolePermissionEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolePermissionEntity record, @Param("example") RolePermissionEntityExample example);

    int updateByExample(@Param("record") RolePermissionEntity record, @Param("example") RolePermissionEntityExample example);

    int updateByPrimaryKeySelective(RolePermissionEntity record);

    int updateByPrimaryKey(RolePermissionEntity record);
}