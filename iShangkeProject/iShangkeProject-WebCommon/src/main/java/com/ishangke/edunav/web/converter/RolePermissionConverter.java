package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.RolePermissionBo;
import com.ishangke.edunav.web.model.RolePermissionVo;

public class RolePermissionConverter {
    public static RolePermissionBo fromModel(RolePermissionVo vo) {
        RolePermissionBo rolePermissionBo = new RolePermissionBo();
        if (vo.getId() != null) {
            rolePermissionBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            rolePermissionBo.setIdSet(vo.getIdSet());
        }
        if (vo.getPermissionId() != null) {
            rolePermissionBo.setPermissionId(vo.getPermissionId());
        }
        if (vo.getPermissionIdSet() != null) {
            rolePermissionBo.setPermissionIdSet(vo.getPermissionIdSet());
        }
        if (vo.getRoleId() != null) {
            rolePermissionBo.setRoleId(vo.getRoleId());
        }
        if (vo.getRoleIdSet() != null) {
            rolePermissionBo.setRoleIdSet(vo.getRoleIdSet());
        }
        rolePermissionBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        rolePermissionBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        rolePermissionBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
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
