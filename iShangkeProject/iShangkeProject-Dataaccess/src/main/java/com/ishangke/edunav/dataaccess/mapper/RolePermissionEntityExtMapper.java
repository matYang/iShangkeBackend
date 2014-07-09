package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.RolePermissionEntityExt;

public interface RolePermissionEntityExtMapper {

    public int add(RolePermissionEntityExt rolePermissionEntityExt);
    public void deleteById(int id);
    public void update(RolePermissionEntityExt rolePermissionEntityExt);
}
