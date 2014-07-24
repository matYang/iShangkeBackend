package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.RolePermissionBo;
import com.ishangke.edunav.web.model.RolePermissionVo;

public class RolePermissionConverter {
    public static RolePermissionBo fromModel(RolePermissionVo vo) {
        RolePermissionBo rolePermissionBo = new RolePermissionBo();
        rolePermissionBo.setId(vo.getId());
        rolePermissionBo.setIdSet(vo.getIdSet());
        rolePermissionBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        rolePermissionBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        rolePermissionBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
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
