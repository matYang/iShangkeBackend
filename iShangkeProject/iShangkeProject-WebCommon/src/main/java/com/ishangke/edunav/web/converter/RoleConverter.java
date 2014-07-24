package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.RoleBo;
import com.ishangke.edunav.web.model.RoleVo;

public class RoleConverter {
    public static RoleBo fromModel(RoleVo vo) {
        RoleBo roleBo = new RoleBo();
        if (vo.getEnabled() != null) {
            roleBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            roleBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            roleBo.setIdSet(vo.getIdSet());
        }
        if (vo.getName() != null) {
            roleBo.setName(vo.getName());
        }
        roleBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        roleBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        roleBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        roleBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        roleBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        roleBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
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
