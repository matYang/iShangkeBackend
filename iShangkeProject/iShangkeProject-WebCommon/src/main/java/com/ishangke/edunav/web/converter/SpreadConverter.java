package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.web.model.SpreadVo;

public class SpreadConverter {
    public static SpreadBo fromModel(SpreadVo vo) {
        if (vo == null) {
            return null;
        }
        SpreadBo spreadBo = new SpreadBo();
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
        } else {
            spreadBo.setStatus(Constant.DEFAULTNULL);
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
        if (vo.getCreateTime() != null) {
            spreadBo.setCreateTime(vo.getCreateTime());
        } else {
            spreadBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            spreadBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            spreadBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            spreadBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            spreadBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            spreadBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            spreadBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            spreadBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            spreadBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            spreadBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            spreadBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return spreadBo;
    }

    public static SpreadVo toModel(SpreadBo bo) {
        if (bo == null) {
            return null;
        }
        SpreadVo spreadVo = new SpreadVo();
        spreadVo.setCourseId(bo.getCourseId());
        spreadVo.setCourseIdSet(bo.getCourseIdSet());
        spreadVo.setCreateTime(bo.getCreateTime());
        spreadVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        spreadVo.setCreateTimeStart(bo.getCreateTimeStart());
        spreadVo.setEnabled(bo.getEnabled());
        spreadVo.setId(bo.getId());
        spreadVo.setIdSet(bo.getIdSet());
        spreadVo.setLastModifyTime(bo.getLastModifyTime());
        spreadVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
        spreadVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        spreadVo.setPartnerId(bo.getPartnerId());
        spreadVo.setPartnerIdSet(bo.getPartnerIdSet());
        spreadVo.setRemark(bo.getRemark());
        if (Constant.DEFAULTNULL != bo.getStatus()) {
            spreadVo.setStatus(bo.getStatus());
        }
        spreadVo.setStatusSet(bo.getStatusSet());
        spreadVo.setUrl(bo.getUrl());
        spreadVo.setUserId(bo.getUserId());
        spreadVo.setUserIdSet(bo.getUserIdSet());
        return spreadVo;
    }
}
