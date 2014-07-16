package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.RolePermissionBo;
import com.ishangke.edunav.dataaccess.model.RolePermissionEntityExt;

public class RolePermissionConverter {
    public static RolePermissionBo toBo(RolePermissionEntityExt e) {
        return new RolePermissionBo();
    }

    public static RolePermissionEntityExt fromBo(RolePermissionBo bo) {
        return new RolePermissionEntityExt();
    }
}
