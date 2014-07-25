package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.PermissionBo;
import com.ishangke.edunav.web.model.PermissionVo;

public class PermissionConverter {
    public static PermissionBo fromModel(PermissionVo vo) {
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
        permissionBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        permissionBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        permissionBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        permissionBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        permissionBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        permissionBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        return permissionBo;
    }

    public static PermissionVo toModel(PermissionBo bo) {
        PermissionVo permissionVo =new PermissionVo();
        permissionVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        permissionVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        permissionVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        permissionVo.setEnabled(bo.getEnabled());
        permissionVo.setId(bo.getId());
        permissionVo.setIdSet(bo.getIdSet());
        permissionVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        permissionVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        permissionVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        permissionVo.setName(bo.getName());
        permissionVo.setPath(bo.getPath());
        permissionVo.setTag(bo.getTag());
        return permissionVo;
    }
}
