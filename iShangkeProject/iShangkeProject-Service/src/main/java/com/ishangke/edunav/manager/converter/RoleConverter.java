package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.RoleBo;
import com.ishangke.edunav.dataaccess.model.RoleEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class RoleConverter {
    public static RoleBo toBo(RoleEntityExt e) {
        RoleBo roleBo = new RoleBo();
        roleBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        roleBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        roleBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        roleBo.setEnabled(e.getEnabled());
        roleBo.setId(e.getId());
        roleBo.setIdSet(e.getIdSet());
        roleBo.setLastModifyTime(e.getLastModifyTime().getTimeInMillis());
        roleBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd().getTimeInMillis());
        roleBo.setLastModifyTimeStart(e.getLastModifyTimeStart().getTimeInMillis());
        roleBo.setName(e.getName());
        return roleBo;
    }

    public static RoleEntityExt fromBo(RoleBo bo) {
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
