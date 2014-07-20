package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.PermissionBo;
import com.ishangke.edunav.web.user.model.PermissionVo;
import com.ishangke.edunav.web.user.common.DateUtility;

public class PermissionConverter {
    public static PermissionBo fromModel(PermissionVo vo) {
        PermissionBo permissionBo = new PermissionBo();
        permissionBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        permissionBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        permissionBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        permissionBo.setEnabled(vo.getEnabled());
        permissionBo.setId(vo.getId());
        permissionBo.setIdSet(vo.getIdSet());
        permissionBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        permissionBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        permissionBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
        permissionBo.setName(vo.getName());
        permissionBo.setPath(vo.getPath());
        permissionBo.setTag(vo.getTag());
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
