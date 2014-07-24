package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.GroupBo;
import com.ishangke.edunav.web.model.GroupVo;

public class GroupConverter {
    public static GroupBo fromModel(GroupVo vo) {
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
        groupBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        groupBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        groupBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        groupBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        groupBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        groupBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        return groupBo;
    }

    public static GroupVo toModel(GroupBo bo) {
        GroupVo groupVo = new GroupVo();
        groupVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        groupVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        groupVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        groupVo.setEnabled(bo.getEnabled());
        groupVo.setId(bo.getId());
        groupVo.setIdSet(bo.getIdSet());
        groupVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        groupVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        groupVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        groupVo.setName(bo.getName());
        groupVo.setPartnerId(bo.getPartnerId());
        groupVo.setPartnerIdSet(bo.getPartnerIdSet());
        groupVo.setRoleId(bo.getRoleId());
        groupVo.setRoleIdSet(bo.getRoleIdSet());
        return groupVo;
    }
}
