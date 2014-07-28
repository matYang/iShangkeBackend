package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.RoleBo;
import com.ishangke.edunav.dataaccess.model.RoleEntityExt;

public class RoleConverter {
    public static RoleBo toBo(RoleEntityExt e) {
        if (e == null) {
            return null;
        }
        RoleBo roleBo = new RoleBo();
        if (e.getEnabled() != null) {
            roleBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            roleBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            roleBo.setIdSet(e.getIdSet());
        }
        if (e.getName() != null) {
            roleBo.setName(e.getName());
        }
        roleBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        roleBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        roleBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart()
                .getTimeInMillis());
        roleBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        roleBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd()
                .getTimeInMillis());
        roleBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        return roleBo;
    }

    public static RoleEntityExt fromBo(RoleBo bo) {
        if (bo == null) {
            return null;
        }
        RoleEntityExt roleEntityExt = new RoleEntityExt();
        roleEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        roleEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        roleEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        roleEntityExt.setEnabled(bo.getEnabled());
        roleEntityExt.setId(bo.getId());
        roleEntityExt.setIdSet(bo.getIdSet());
        roleEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        roleEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        roleEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        roleEntityExt.setName(bo.getName());
        return roleEntityExt;
    }
}
