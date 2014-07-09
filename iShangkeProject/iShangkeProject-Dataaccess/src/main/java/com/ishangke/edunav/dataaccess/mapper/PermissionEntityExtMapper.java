package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.PermissionEntityExt;

public interface PermissionEntityExtMapper {

    public int add(PermissionEntityExt permissionEntityExt);
    public void deleteById(int id);
    public void update(PermissionEntityExt permissionEntityExt);
}
