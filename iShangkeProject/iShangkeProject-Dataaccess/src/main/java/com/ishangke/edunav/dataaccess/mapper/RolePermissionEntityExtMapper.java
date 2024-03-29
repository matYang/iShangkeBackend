package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.RolePermissionEntityExt;

public interface RolePermissionEntityExtMapper {

    public int add(RolePermissionEntityExt rolePermissionEntityExt);

    public void deleteById(int id);

    public void update(RolePermissionEntityExt rolePermissionEntityExt);

    public List<RolePermissionEntityExt> list(
            @Param("entity") RolePermissionEntityExt rolePermissionEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") RolePermissionEntityExt rolePermissionEntityExt);

    public List<RolePermissionEntityExt> listAll();

    public int getCount();

    public RolePermissionEntityExt getById(int id);
}
