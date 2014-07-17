package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.PermissionEntityExt;

public interface PermissionEntityExtMapper {

    public int add(PermissionEntityExt permissionEntityExt);

    public void deleteById(int id);

    public void update(PermissionEntityExt permissionEntityExt);

    public List<PermissionEntityExt> list(
            @Param("entity") PermissionEntityExt permissionEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") PermissionEntityExt permissionEntityExt);

    public List<PermissionEntityExt> listAll();

    public int getCount();

    public List<PermissionEntityExt> listPermissionByRoleId(int roleId);
    
    public int getCountByRoleId(int roleId);
    
    public List<PermissionEntityExt> listPermissionsByUserId(int userId);

    public int getCountByUserId(int userId);
    
    public List<PermissionEntityExt> listPermissionsByGroupId(int groupId);
    
    public int getCountByGroupId(int groupId);
    
    public PermissionEntityExt getById(int id);
}
