package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.RolePermissionBo;
import com.ishangke.edunav.dataaccess.model.RolePermissionEntityExt;

public class RolePermissionConverter {
    public static RolePermissionBo toBo(RolePermissionEntityExt e) {
        RolePermissionBo rolePermissionBo = new RolePermissionBo();
        return rolePermissionBo;
    }

    public static RolePermissionEntityExt fromBo(RolePermissionBo bo) {
        RolePermissionEntityExt rolePermissionEntityExt = new RolePermissionEntityExt();
        return rolePermissionEntityExt;
    }
}
