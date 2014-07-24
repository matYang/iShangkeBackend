package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.GroupBo;
import com.ishangke.edunav.web.model.GroupVo;

public class GroupConverter {
    public static GroupBo fromModel(GroupVo vo) {
        GroupBo groupBo = new GroupBo();
        groupBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        groupBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        groupBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        groupBo.setEnabled(vo.getEnabled());
        groupBo.setId(vo.getId());
        groupBo.setIdSet(vo.getIdSet());
        groupBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        groupBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        groupBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        groupBo.setName(vo.getName());
        groupBo.setPartnerId(vo.getPartnerId());
        groupBo.setPartnerIdSet(vo.getPartnerIdSet());
        groupBo.setRoleId(vo.getRoleId());
        groupBo.setRoleIdSet(vo.getRoleIdSet());
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
