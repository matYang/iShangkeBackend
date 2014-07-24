package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.PermissionBo;
import com.ishangke.edunav.dataaccess.model.PermissionEntityExt;

public class PermissionConverter {
    public static PermissionBo toBo(PermissionEntityExt e) {
        PermissionBo permissionBo = new PermissionBo();
        permissionBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        permissionBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        permissionBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        permissionBo.setEnabled(e.getEnabled());
        permissionBo.setId(e.getId());
        permissionBo.setIdSet(e.getIdSet());
        permissionBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        permissionBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        permissionBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        permissionBo.setName(e.getName());
        permissionBo.setPath(e.getPath());
        permissionBo.setTag(e.getTag());
        return permissionBo;
    }

    public static PermissionEntityExt fromBo(PermissionBo bo) {
        PermissionEntityExt permissionEntityExt =new PermissionEntityExt();
        permissionEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        permissionEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        permissionEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        permissionEntityExt.setEnabled(bo.getEnabled());
        permissionEntityExt.setId(bo.getId());
        permissionEntityExt.setIdSet(bo.getIdSet());
        permissionEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        permissionEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        permissionEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        permissionEntityExt.setName(bo.getName());
        permissionEntityExt.setPath(bo.getPath());
        permissionEntityExt.setTag(bo.getTag());
        return permissionEntityExt;
    }
}
