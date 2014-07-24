package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.dataaccess.model.SpreadEntityExt;

public class SpreadConverter {
    public static SpreadBo toBo(SpreadEntityExt e) {
        SpreadBo spreadBo =new SpreadBo();
        if (e.getCourseId() != null) {
            spreadBo.setCourseId(e.getCourseId());
        }
        if (e.getCourseIdSet() != null) {
            spreadBo.setCourseIdSet(e.getCourseIdSet());
        }
        if (e.getEnabled() != null) {
            spreadBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            spreadBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            spreadBo.setIdSet(e.getIdSet());
        }
        if (e.getPartnerId() != null) {
            spreadBo.setPartnerId(e.getPartnerId());
        }
        if (e.getPartnerIdSet() != null) {
            spreadBo.setPartnerIdSet(e.getPartnerIdSet());
        }
        if (e.getRemark() != null) {
            spreadBo.setRemark(e.getRemark());
        }
        if (e.getStatus() != null) {
            spreadBo.setStatus(e.getStatus());
        }
        if (e.getStatusSet() != null) {
            spreadBo.setStatusSet(e.getStatusSet());
        }
        if (e.getUrl() != null) {
            spreadBo.setUrl(e.getUrl());
        }
        if (e.getUserId() != null) {
            spreadBo.setUserId(e.getUserId());
        }
        if (e.getUserIdSet() != null) {
            spreadBo.setUserIdSet(e.getUserIdSet());
        }
        spreadBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        spreadBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        spreadBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        spreadBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        spreadBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        spreadBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
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
