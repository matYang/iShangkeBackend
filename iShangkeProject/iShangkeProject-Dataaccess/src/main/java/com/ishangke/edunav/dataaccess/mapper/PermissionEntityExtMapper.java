package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.PermissionEntityExt;

public interface PermissionEntityExtMapper {

    public int add(PermissionEntityExt permissionEntityExt);

    public void deleteById(int id);

    public void update(PermissionEntityExt permissionEntityExt);

    public int getCount();

    public List<PermissionEntityExt> list(
            @Param("entity") PermissionEntityExt permissionEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(
            @Param("entity") PermissionEntityExt permissionEntityExt,
            @Param("page") PaginationEntity page);
    
    public List<PermissionEntityExt>listPermissionByRoleId(int roleId);
}
