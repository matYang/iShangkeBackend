package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.PermissionEntityExt;

public interface PermissionEntityExtMapper {

    public int add(PermissionEntityExt permissionEntityExt);
    
    public void deleteById(int id);
    
    public void update(PermissionEntityExt permissionEntityExt);
    
    public int getCount();

    public List<PermissionEntityExt> list(PermissionEntityExt permissionEntityExt);
}
