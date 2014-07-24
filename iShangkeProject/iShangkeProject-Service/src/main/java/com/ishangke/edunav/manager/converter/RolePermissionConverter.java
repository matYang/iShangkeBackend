package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.RolePermissionBo;
import com.ishangke.edunav.dataaccess.model.RolePermissionEntityExt;

public class RolePermissionConverter {
    public static RolePermissionBo toBo(RolePermissionEntityExt e) {
        RolePermissionBo rolePermissionBo = new RolePermissionBo();
        rolePermissionBo.setId(e.getId());
        rolePermissionBo.setIdSet(e.getIdSet());
        rolePermissionBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        rolePermissionBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        rolePermissionBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
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
