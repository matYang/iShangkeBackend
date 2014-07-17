package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.RoleBo;
import com.ishangke.edunav.web.user.model.RoleVo;

public class RoleConverter {
    public static RoleBo fromModel(RoleVo e) {
        RoleBo roleBo = new RoleBo();
        return roleBo;
    }

    public static RoleVo toModel(RoleBo bo) {
        RoleVo roleVo = new RoleVo();
        return roleVo;
    }
}
