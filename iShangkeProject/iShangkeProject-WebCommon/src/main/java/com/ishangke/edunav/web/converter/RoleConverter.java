package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.RoleBo;
import com.ishangke.edunav.web.model.RoleVo;

public class RoleConverter {
    public static RoleBo fromModel(RoleVo vo) {
        if (vo == null) {
            return null;
        }
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
        if (vo.getCreateTime() != null) {
            roleBo.setCreateTime(vo.getCreateTime());
        } else {
            roleBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            roleBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            roleBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            roleBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            roleBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            roleBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            roleBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            roleBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            roleBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            roleBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            roleBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return roleBo;
    }

    public static RoleVo toModel(RoleBo bo) {
        if (bo == null) {
            return null;
        }
        RoleVo roleVo = new RoleVo();
        roleVo.setCreateTime(bo.getCreateTime());
//        roleVo.setCreateTimeEnd(bo.getCreateTimeEnd());
//        roleVo.setCreateTimeStart(bo.getCreateTimeStart());
        roleVo.setEnabled(bo.getEnabled());
        roleVo.setId(bo.getId());
//        roleVo.setIdSet(bo.getIdSet());
        roleVo.setLastModifyTime(bo.getLastModifyTime());
//        roleVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
//        roleVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        roleVo.setName(bo.getName());
        return roleVo;
    }
}
