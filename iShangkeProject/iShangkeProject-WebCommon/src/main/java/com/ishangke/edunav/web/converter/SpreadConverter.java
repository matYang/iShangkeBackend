package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.web.model.SpreadVo;
import com.ishangke.edunav.web.common.DateUtility;

public class SpreadConverter {
    public static SpreadBo fromModel(SpreadVo vo) {
        SpreadBo spreadBo =new SpreadBo();
        spreadBo.setCourseId(vo.getCourseId());
        spreadBo.setCourseIdSet(vo.getCourseIdSet());
        spreadBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        spreadBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        spreadBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        spreadBo.setEnabled(vo.getEnabled());
        spreadBo.setId(vo.getId());
        spreadBo.setIdSet(vo.getIdSet());
        spreadBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        spreadBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        spreadBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
        spreadBo.setPartnerId(vo.getPartnerId());
        spreadBo.setPartnerIdSet(vo.getPartnerIdSet());
        spreadBo.setRemark(vo.getRemark());
        spreadBo.setStatus(vo.getStatus());
        spreadBo.setStatusSet(vo.getStatusSet());
        spreadBo.setUrl(vo.getUrl());
        spreadBo.setUserId(vo.getUserId());
        spreadBo.setUserIdSet(vo.getUserIdSet());
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
