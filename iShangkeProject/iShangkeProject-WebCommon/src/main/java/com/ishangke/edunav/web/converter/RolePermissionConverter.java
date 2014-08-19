package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.RolePermissionBo;
import com.ishangke.edunav.web.model.RolePermissionVo;

public class RolePermissionConverter {
    public static RolePermissionBo fromModel(RolePermissionVo vo) {
        if (vo == null) {
            return null;
        }
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
        if (vo.getLastModifyTime() != null) {
            rolePermissionBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            rolePermissionBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            rolePermissionBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            rolePermissionBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            rolePermissionBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            rolePermissionBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return rolePermissionBo;
    }

    public static RolePermissionVo toModel(RolePermissionBo bo) {
        if (bo == null) {
            return null;
        }
        RolePermissionVo rolePermissionVo = new RolePermissionVo();
        rolePermissionVo.setId(bo.getId());
//        rolePermissionVo.setIdSet(bo.getIdSet());
        rolePermissionVo.setLastModifyTime(bo.getLastModifyTime());
//        rolePermissionVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
//        rolePermissionVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        rolePermissionVo.setPermissionId(bo.getPermissionId());
//        rolePermissionVo.setPermissionIdSet(bo.getPermissionIdSet());
        rolePermissionVo.setRoleId(bo.getRoleId());
//        rolePermissionVo.setRoleIdSet(bo.getRoleIdSet());
        return rolePermissionVo;
    }
}
