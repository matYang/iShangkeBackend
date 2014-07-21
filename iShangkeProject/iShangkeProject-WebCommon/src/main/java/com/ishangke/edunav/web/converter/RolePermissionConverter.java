package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.RolePermissionBo;
import com.ishangke.edunav.web.model.RolePermissionVo;
import com.ishangke.edunav.web.common.DateUtility;

public class RolePermissionConverter {
    public static RolePermissionBo fromModel(RolePermissionVo vo) {
        RolePermissionBo rolePermissionBo = new RolePermissionBo();
        rolePermissionBo.setId(vo.getId());
        rolePermissionBo.setIdSet(vo.getIdSet());
        rolePermissionBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        rolePermissionBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        rolePermissionBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
        rolePermissionBo.setPermissionId(vo.getPermissionId());
        rolePermissionBo.setPermissionIdSet(vo.getPermissionIdSet());
        rolePermissionBo.setRoleId(vo.getRoleId());
        rolePermissionBo.setRoleIdSet(vo.getRoleIdSet());
        return rolePermissionBo;
    }

    public static RolePermissionVo toModel(RolePermissionBo bo) {
        RolePermissionVo rolePermissionVo = new RolePermissionVo();
        rolePermissionVo.setId(bo.getId());
        rolePermissionVo.setIdSet(bo.getIdSet());
        rolePermissionVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        rolePermissionVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        rolePermissionVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        rolePermissionVo.setPermissionId(bo.getPermissionId());
        rolePermissionVo.setPermissionIdSet(bo.getPermissionIdSet());
        rolePermissionVo.setRoleId(bo.getRoleId());
        rolePermissionVo.setRoleIdSet(bo.getRoleIdSet());
        return rolePermissionVo;
    }
}
