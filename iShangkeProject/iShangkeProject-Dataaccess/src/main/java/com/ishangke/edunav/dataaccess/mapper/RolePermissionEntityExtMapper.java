package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.RolePermissionEntityExt;

public interface RolePermissionEntityExtMapper {

    public int add(RolePermissionEntityExt rolePermissionEntityExt);
    
    public void deleteById(int id);
    
    public void update(RolePermissionEntityExt rolePermissionEntityExt);
    
    public int getCount();

    public List<RolePermissionEntityExt> list(RolePermissionEntityExt rolePermissionEntityExt);
}
