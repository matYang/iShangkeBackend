package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.GroupBo;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;

public class GroupConverter {
    public static GroupBo toBo(GroupEntityExt e) {
        GroupBo groupBo = new GroupBo();
        groupBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        groupBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        groupBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        groupBo.setEnabled(e.getEnabled());
        groupBo.setId(e.getId());
        groupBo.setIdSet(e.getIdSet());
        groupBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        groupBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        groupBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        groupBo.setName(e.getName());
        groupBo.setPartnerId(e.getPartnerId());
        groupBo.setPartnerIdSet(e.getPartnerIdSet());
        groupBo.setRoleId(e.getRoleId());
        groupBo.setRoleIdSet(e.getRoleIdSet());
        return groupBo;
    }

    public static GroupEntityExt fromBo(GroupBo bo) {
        GroupEntityExt groupEntityExt = new GroupEntityExt();
        groupEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        groupEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        groupEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        groupEntityExt.setEnabled(bo.getEnabled());
        groupEntityExt.setId(bo.getId());
        groupEntityExt.setIdSet(bo.getIdSet());
        groupEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        groupEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        groupEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        groupEntityExt.setName(bo.getName());
        groupEntityExt.setPartnerId(bo.getPartnerId());
        groupEntityExt.setPartnerIdSet(bo.getPartnerIdSet());
        groupEntityExt.setRoleId(bo.getRoleId());
        groupEntityExt.setRoleIdSet(bo.getRoleIdSet());
        return groupEntityExt;
    }
}
