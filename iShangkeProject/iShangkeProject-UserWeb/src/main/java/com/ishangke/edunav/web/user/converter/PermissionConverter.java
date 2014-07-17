package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.PermissionBo;
import com.ishangke.edunav.web.user.model.PermissionVo;

public class PermissionConverter {
    public static PermissionBo fromModel(PermissionVo e) {
        PermissionBo permissionBo = new PermissionBo();
        return permissionBo;
    }

    public static PermissionVo toModel(PermissionBo bo) {
        PermissionVo permissionVo =new PermissionVo();
        return permissionVo;
    }
}
