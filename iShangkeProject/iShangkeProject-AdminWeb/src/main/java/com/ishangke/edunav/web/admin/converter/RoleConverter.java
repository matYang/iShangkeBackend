package com.ishangke.edunav.web.admin.converter;

import com.ishangke.edunav.commoncontract.model.RoleBo;
import com.ishangke.edunav.dataaccess.model.RoleEntityExt;

public class RoleConverter {
    public static RoleBo toBo(RoleEntityExt e) {
        RoleBo roleBo = new RoleBo();
        return roleBo;
    }

    public static RoleEntityExt fromBo(RoleBo bo) {
        RoleEntityExt roleEntityExt = new RoleEntityExt();
        return roleEntityExt;
    }
}
