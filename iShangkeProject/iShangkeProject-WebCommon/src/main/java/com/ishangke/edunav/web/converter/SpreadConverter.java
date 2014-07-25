package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.web.model.SpreadVo;

public class SpreadConverter {
    public static SpreadBo fromModel(SpreadVo vo) {
        SpreadBo spreadBo =new SpreadBo();
        if (vo.getCourseId() != null) {
            spreadBo.setCourseId(vo.getCourseId());
        }
        if (vo.getCourseIdSet() != null) {
            spreadBo.setCourseIdSet(vo.getCourseIdSet());
        }
        if (vo.getEnabled() != null) {
            spreadBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            spreadBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            spreadBo.setIdSet(vo.getIdSet());
        }
        if (vo.getPartnerId() != null) {
            spreadBo.setPartnerId(vo.getPartnerId());
        }
        if (vo.getPartnerIdSet() != null) {
            spreadBo.setPartnerIdSet(vo.getPartnerIdSet());
        }
        if (vo.getRemark() != null) {
            spreadBo.setRemark(vo.getRemark());
        }
        if (vo.getStatus() != null) {
            spreadBo.setStatus(vo.getStatus());
        }
        if (vo.getStatusSet() != null) {
            spreadBo.setStatusSet(vo.getStatusSet());
        }
        if (vo.getUrl() != null) {
            spreadBo.setUrl(vo.getUrl());
        }
        if (vo.getUserId() != null) {
            spreadBo.setUserId(vo.getUserId());
        }
        if (vo.getUserIdSet() != null) {
            spreadBo.setUserIdSet(vo.getUserIdSet());
        }
        spreadBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        spreadBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        spreadBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        spreadBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        spreadBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        spreadBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        return spreadBo;
    }

    public static SpreadVo toModel(SpreadBo bo) {
        SpreadVo spreadVo =new SpreadVo();
        spreadVo.setCourseId(bo.getCourseId());
        spreadVo.setCourseIdSet(bo.getCourseIdSet());
        spreadVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        spreadVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        spreadVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        spreadVo.setEnabled(bo.getEnabled());
        spreadVo.setId(bo.getId());
        spreadVo.setIdSet(bo.getIdSet());
        spreadVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        spreadVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        spreadVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        spreadVo.setPartnerId(bo.getPartnerId());
        spreadVo.setPartnerIdSet(bo.getPartnerIdSet());
        spreadVo.setRemark(bo.getRemark());
        spreadVo.setStatus(bo.getStatus());
        spreadVo.setStatusSet(bo.getStatusSet());
        spreadVo.setUrl(bo.getUrl());
        spreadVo.setUserId(bo.getUserId());
        spreadVo.setUserIdSet(bo.getUserIdSet());
        return spreadVo;
    }
}
