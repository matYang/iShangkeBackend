package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.RolePermissionBo;
import com.ishangke.edunav.web.user.model.RolePermissionVo;

public class RolePermissionConverter {
    public static RolePermissionBo fromModel(RolePermissionVo e) {
        RolePermissionBo rolePermissionBo = new RolePermissionBo();
        return rolePermissionBo;
    }

    public static RolePermissionVo toModel(RolePermissionBo bo) {
        RolePermissionVo rolePermissionVo = new RolePermissionVo();
        return rolePermissionVo;
    }
}
