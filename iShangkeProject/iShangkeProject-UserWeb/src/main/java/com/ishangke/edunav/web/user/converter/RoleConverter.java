package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.RoleBo;
import com.ishangke.edunav.web.user.model.RoleVo;
import com.ishangke.edunav.web.user.common.DateUtility;

public class RoleConverter {
    public static RoleBo fromModel(RoleVo vo) {
        RoleBo roleBo = new RoleBo();
        roleBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        roleBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        roleBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        roleBo.setEnabled(vo.getEnabled());
        roleBo.setId(vo.getId());
        roleBo.setIdSet(vo.getIdSet());
        roleBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        roleBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        roleBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
        roleBo.setName(vo.getName());
        return roleBo;
    }

    public static RoleVo toModel(RoleBo bo) {
        RoleVo roleVo = new RoleVo();
        roleVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        roleVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        roleVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        roleVo.setEnabled(bo.getEnabled());
        roleVo.setId(bo.getId());
        roleVo.setIdSet(bo.getIdSet());
        roleVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        roleVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        roleVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        roleVo.setName(bo.getName());
        return roleVo;
    }
}
