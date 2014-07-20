package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.dataaccess.model.SpreadEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class SpreadConverter {
    public static SpreadBo toBo(SpreadEntityExt e) {
        SpreadBo spreadBo =new SpreadBo();
        spreadBo.setCourseId(e.getCourseId());
        spreadBo.setCourseIdSet(e.getCourseIdSet());
        spreadBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        spreadBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        spreadBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        spreadBo.setEnabled(e.getEnabled());
        spreadBo.setId(e.getId());
        spreadBo.setIdSet(e.getIdSet());
        spreadBo.setLastModifyTime(e.getLastModifyTime().getTimeInMillis());
        spreadBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd().getTimeInMillis());
        spreadBo.setLastModifyTimeStart(e.getLastModifyTimeStart().getTimeInMillis());
        spreadBo.setPartnerId(e.getPartnerId());
        spreadBo.setPartnerIdSet(e.getPartnerIdSet());
        spreadBo.setRemark(e.getRemark());
        spreadBo.setStatus(e.getStatus());
        spreadBo.setStatusSet(e.getStatusSet());
        spreadBo.setUrl(e.getUrl());
        spreadBo.setUserId(e.getUserId());
        spreadBo.setUserIdSet(e.getUserIdSet());
        return spreadBo;
    }

    public static SpreadEntityExt fromBo(SpreadBo bo) {
        SpreadEntityExt spreadEntityExt =new SpreadEntityExt();
        spreadEntityExt.setCourseId(bo.getCourseId());
        spreadEntityExt.setCourseIdSet(bo.getCourseIdSet());
        spreadEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        spreadEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        spreadEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        spreadEntityExt.setEnabled(bo.getEnabled());
        spreadEntityExt.setId(bo.getId());
        spreadEntityExt.setIdSet(bo.getIdSet());
        spreadEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        spreadEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        spreadEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        spreadEntityExt.setPartnerId(bo.getPartnerId());
        spreadEntityExt.setPartnerIdSet(bo.getPartnerIdSet());
        spreadEntityExt.setRemark(bo.getRemark());
        spreadEntityExt.setStatus(bo.getStatus());
        spreadEntityExt.setStatusSet(bo.getStatusSet());
        spreadEntityExt.setUrl(bo.getUrl());
        spreadEntityExt.setUserId(bo.getUserId());
        spreadEntityExt.setUserIdSet(bo.getUserIdSet());
        return spreadEntityExt;
    }
}
