package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.GroupBo;
import com.ishangke.edunav.web.model.GroupVo;

public class GroupConverter {
    public static GroupBo fromModel(GroupVo vo) {
        if (vo == null) {
            return null;
        }
        GroupBo groupBo = new GroupBo();
        if (vo.getEnabled() != null) {
            groupBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            groupBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            groupBo.setIdSet(vo.getIdSet());
        }
        if (vo.getName() != null) {
            groupBo.setName(vo.getName());
        }
        if (vo.getPartnerId() != null) {
            groupBo.setPartnerId(vo.getPartnerId());
        }
        if (vo.getPartnerIdSet() != null) {
            groupBo.setPartnerIdSet(vo.getPartnerIdSet());
        }
        if (vo.getRoleId() != null) {
            groupBo.setRoleId(vo.getRoleId());
        }
        if (vo.getRoleIdSet() != null) {
            groupBo.setRoleIdSet(vo.getRoleIdSet());
        }
        if (vo.getCreateTime() != null) {
            groupBo.setCreateTime(vo.getCreateTime());
        } else {
            groupBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            groupBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            groupBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            groupBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            groupBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            groupBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            groupBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            groupBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            groupBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            groupBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            groupBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return groupBo;
    }

    public static GroupVo toModel(GroupBo bo) {

        if (bo == null) {
            return null;
        }
        GroupVo groupVo = new GroupVo();
        groupVo.setCreateTime(bo.getCreateTime());
        groupVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        groupVo.setCreateTimeStart(bo.getCreateTimeStart());
        groupVo.setEnabled(bo.getEnabled());
        groupVo.setId(bo.getId());
        groupVo.setIdSet(bo.getIdSet());
        groupVo.setLastModifyTime(bo.getLastModifyTime());
        groupVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
        groupVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        groupVo.setName(bo.getName());
        groupVo.setPartnerId(bo.getPartnerId());
        groupVo.setPartnerIdSet(bo.getPartnerIdSet());
        groupVo.setRoleId(bo.getRoleId());
        groupVo.setRoleIdSet(bo.getRoleIdSet());
        return groupVo;
    }
}
