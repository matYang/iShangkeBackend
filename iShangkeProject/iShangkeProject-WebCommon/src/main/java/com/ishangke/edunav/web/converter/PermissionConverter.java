package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.PermissionBo;
import com.ishangke.edunav.web.model.PermissionVo;

public class PermissionConverter {
    public static PermissionBo fromModel(PermissionVo vo) {
        if (vo == null) {
            return null;
        }
        PermissionBo permissionBo = new PermissionBo();
        if (vo.getEnabled() != null) {
            permissionBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            permissionBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            permissionBo.setIdSet(vo.getIdSet());
        }
        if (vo.getName() != null) {
            permissionBo.setName(vo.getName());
        }
        if (vo.getPath() != null) {
            permissionBo.setPath(vo.getPath());
        }
        if (vo.getTag() != null) {
            permissionBo.setTag(vo.getTag());
        }
        if (vo.getCreateTime() != null) {
            permissionBo.setCreateTime(vo.getCreateTime());
        } else {
            permissionBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            permissionBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            permissionBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            permissionBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            permissionBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            permissionBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            permissionBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            permissionBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            permissionBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            permissionBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            permissionBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return permissionBo;
    }

    public static PermissionVo toModel(PermissionBo bo) {
        if (bo == null) {
            return null;
        }
        PermissionVo permissionVo = new PermissionVo();
        permissionVo.setCreateTime(bo.getCreateTime());
        permissionVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        permissionVo.setCreateTimeStart(bo.getCreateTimeStart());
        permissionVo.setEnabled(bo.getEnabled());
        permissionVo.setId(bo.getId());
        permissionVo.setIdSet(bo.getIdSet());
        permissionVo.setLastModifyTime(bo.getLastModifyTime());
        permissionVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
        permissionVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        permissionVo.setName(bo.getName());
        permissionVo.setPath(bo.getPath());
        permissionVo.setTag(bo.getTag());
        return permissionVo;
    }
}
