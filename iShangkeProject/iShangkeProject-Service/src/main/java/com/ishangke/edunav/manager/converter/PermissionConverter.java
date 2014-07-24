package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.PermissionBo;
import com.ishangke.edunav.dataaccess.model.PermissionEntityExt;

public class PermissionConverter {
    public static PermissionBo toBo(PermissionEntityExt e) {
        PermissionBo permissionBo = new PermissionBo();
        if (e.getEnabled()!= null) {
            permissionBo.setEnabled(e.getEnabled());
        }
        if (e.getId()!= null) {
            permissionBo.setId(e.getId());
        }
        if (e.getIdSet()!= null) {
            permissionBo.setIdSet(e.getIdSet());
        }
        if (e.getName()!= null) {
            permissionBo.setName(e.getName());
        }
        if (e.getPath()!= null) {
            permissionBo.setPath(e.getPath());
        }
        if (e.getTag()!= null) {
            permissionBo.setTag(e.getTag());
        }
        permissionBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        permissionBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        permissionBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        permissionBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        permissionBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        permissionBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
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
