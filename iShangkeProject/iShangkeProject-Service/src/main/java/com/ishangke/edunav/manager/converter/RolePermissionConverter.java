package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.RolePermissionBo;
import com.ishangke.edunav.dataaccess.model.RolePermissionEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class RolePermissionConverter {
    public static RolePermissionBo toBo(RolePermissionEntityExt e) {
        RolePermissionBo rolePermissionBo = new RolePermissionBo();
        rolePermissionBo.setId(e.getId());
        rolePermissionBo.setIdSet(e.getIdSet());
        rolePermissionBo.setLastModifyTime(e.getLastModifyTime().getTimeInMillis());
        rolePermissionBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd().getTimeInMillis());
        rolePermissionBo.setLastModifyTimeStart(e.getLastModifyTimeStart().getTimeInMillis());
        rolePermissionBo.setPermissionId(e.getPermissionId());
        rolePermissionBo.setPermissionIdSet(e.getPermissionIdSet());
        rolePermissionBo.setRoleId(e.getRoleId());
        rolePermissionBo.setRoleIdSet(e.getRoleIdSet());
        return rolePermissionBo;
    }

    public static RolePermissionEntityExt fromBo(RolePermissionBo bo) {
        RolePermissionEntityExt rolePermissionEntityExt = new RolePermissionEntityExt();
        rolePermissionEntityExt.setId(bo.getId());
        rolePermissionEntityExt.setIdSet(bo.getIdSet());
        rolePermissionEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        rolePermissionEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        rolePermissionEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        rolePermissionEntityExt.setPermissionId(bo.getPermissionId());
        rolePermissionEntityExt.setPermissionIdSet(bo.getPermissionIdSet());
        rolePermissionEntityExt.setRoleId(bo.getRoleId());
        rolePermissionEntityExt.setRoleIdSet(bo.getRoleIdSet());
        return rolePermissionEntityExt;
    }
}
