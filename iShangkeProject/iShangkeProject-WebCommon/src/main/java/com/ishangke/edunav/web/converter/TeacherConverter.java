package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.web.model.TeacherVo;

public class TeacherConverter {
    public static TeacherBo fromModel(TeacherVo vo) {
        TeacherBo teacherBo = new TeacherBo();
        if (vo.getEnabled() != null) {
            teacherBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            teacherBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            teacherBo.setIdSet(vo.getIdSet());
        }
        if (vo.getImgUrl() != null) {
            teacherBo.setImgUrl(vo.getImgUrl());
        }
        if (vo.getIntro() != null) {
            teacherBo.setIntro(vo.getIntro());
        }
        if (vo.getName() != null) {
            teacherBo.setName(vo.getName());
        }
        if (vo.getPartnerId() != null) {
            teacherBo.setPartnerId(vo.getPartnerId());
        }
        if (vo.getPartnerIdSet() != null) {
            teacherBo.setPartnerIdSet(vo.getPartnerIdSet());
        }
        if (vo.getPopularity() != null) {
            teacherBo.setPopularity(vo.getPopularity());
        }  else {
            teacherBo.setPopularity(Constant.DEFAULTNULL);
        }
        if (vo.getPopularityEnd() != null) {
            teacherBo.setPopularityEnd(vo.getPopularityEnd());
        }
        if (vo.getPopularitySet() != null) {
            teacherBo.setPopularitySet(vo.getPopularitySet());
        }
        if (vo.getPopularityStart() != null) {
            teacherBo.setPopularityStart(vo.getPopularityStart());
        }
        teacherBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        teacherBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        teacherBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        teacherBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        teacherBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        teacherBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        return teacherBo;
    }

    public static TeacherVo toModel(TeacherBo bo) {
        TeacherVo teacherVo = new TeacherVo();
        teacherVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        teacherVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        teacherVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        teacherVo.setEnabled(bo.getEnabled());
        teacherVo.setId(bo.getId());
        teacherVo.setIdSet(bo.getIdSet());
        teacherVo.setImgUrl(bo.getImgUrl());
        teacherVo.setIntro(bo.getIntro());
        teacherVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        teacherVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        teacherVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        teacherVo.setName(bo.getName());
        teacherVo.setPartnerId(bo.getPartnerId());
        teacherVo.setPartnerIdSet(bo.getPartnerIdSet());
        if (Constant.DEFAULTNULL != bo.getPopularity()) {
        teacherVo.setPopularity(bo.getPopularity());
        }
        teacherVo.setPopularityEnd(bo.getPopularityEnd());
        teacherVo.setPopularitySet(bo.getPopularitySet());
        teacherVo.setPopularityStart(bo.getPopularityStart());
        return teacherVo;
    }
}
