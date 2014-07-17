package com.ishangke.edunav.web.partner.converter;

import com.ishangke.edunav.commoncontract.model.PermissionBo;
import com.ishangke.edunav.dataaccess.model.PermissionEntityExt;

public class PermissionConverter {
    public static PermissionBo toBo(PermissionEntityExt e) {
        PermissionBo permissionBo = new PermissionBo();
        return permissionBo;
    }

    public static PermissionEntityExt fromBo(PermissionBo bo) {
        PermissionEntityExt permissionEntityExt =new PermissionEntityExt();
        return permissionEntityExt;
    }
}
