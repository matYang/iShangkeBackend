package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.PermissionBo;
import com.ishangke.edunav.dataaccess.model.PermissionEntityExt;

public class PermissionConverter {
    public static PermissionBo toBo(PermissionEntityExt e) {
        return new PermissionBo();
    }

    public static PermissionEntityExt fromBo(PermissionBo bo) {
        return new PermissionEntityExt();
    }
}
