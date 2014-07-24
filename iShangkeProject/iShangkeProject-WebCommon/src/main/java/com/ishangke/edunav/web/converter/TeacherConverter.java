package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.web.model.TeacherVo;

public class TeacherConverter {
    public static TeacherBo fromModel(TeacherVo vo) {
        TeacherBo teacherBo = new TeacherBo();
        teacherBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        teacherBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        teacherBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        teacherBo.setEnabled(vo.getEnabled());
        teacherBo.setId(vo.getId());
        teacherBo.setIdSet(vo.getIdSet());
        teacherBo.setImgUrl(vo.getImgUrl());
        teacherBo.setIntro(vo.getIntro());
        teacherBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        teacherBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        teacherBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        teacherBo.setName(vo.getName());
        teacherBo.setPartnerId(vo.getPartnerId());
        teacherBo.setPartnerIdSet(vo.getPartnerIdSet());
        teacherBo.setPopularity(vo.getPopularity());
        teacherBo.setPopularityEnd(vo.getPopularityEnd());
        teacherBo.setPopularitySet(vo.getPopularitySet());
        teacherBo.setPopularityStart(vo.getPopularityStart());
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
        teacherVo.setPopularity(bo.getPopularity());
        teacherVo.setPopularityEnd(bo.getPopularityEnd());
        teacherVo.setPopularitySet(bo.getPopularitySet());
        teacherVo.setPopularityStart(bo.getPopularityStart());
        return teacherVo;
    }
}
