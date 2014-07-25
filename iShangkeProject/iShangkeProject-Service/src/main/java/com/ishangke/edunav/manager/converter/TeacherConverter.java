package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

public class TeacherConverter {
    public static TeacherBo toBo(TeacherEntityExt e) {
        TeacherBo teacherBo = new TeacherBo();
        if (e.getEnabled() != null) {
            teacherBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            teacherBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            teacherBo.setIdSet(e.getIdSet());
        }
        if (e.getImgUrl() != null) {
            teacherBo.setImgUrl(e.getImgUrl());
        }
        if (e.getIntro() != null) {
            teacherBo.setIntro(e.getIntro());
        }
        if (e.getName() != null) {
            teacherBo.setName(e.getName());
        }
        if (e.getPartnerId() != null) {
            teacherBo.setPartnerId(e.getPartnerId());
        }
        if (e.getPartnerIdSet() != null) {
            teacherBo.setPartnerIdSet(e.getPartnerIdSet());
        }
        if (e.getPopularity() != null) {
            teacherBo.setPopularity(e.getPopularity());
        }else {
            teacherBo.setPopularity(Constant.DEFAULTNULL);
        }
        if (e.getPopularityEnd() != null) {
            teacherBo.setPopularityEnd(e.getPopularityEnd());
        }
        if (e.getPopularitySet() != null) {
            teacherBo.setPopularitySet(e.getPopularitySet());
        }
        if (e.getPopularityStart() != null) {
            teacherBo.setPopularityStart(e.getPopularityStart());
        }
        teacherBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        teacherBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        teacherBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        teacherBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        teacherBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        teacherBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        return teacherBo;
    }

    public static TeacherEntityExt fromBo(TeacherBo bo) {
        TeacherEntityExt teacherEntityExt = new TeacherEntityExt();
        teacherEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        teacherEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        teacherEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        teacherEntityExt.setEnabled(bo.getEnabled());
        teacherEntityExt.setId(bo.getId());
        teacherEntityExt.setIdSet(bo.getIdSet());
        teacherEntityExt.setImgUrl(bo.getImgUrl());
        teacherEntityExt.setIntro(bo.getIntro());
        teacherEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        teacherEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        teacherEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        teacherEntityExt.setName(bo.getName());
        teacherEntityExt.setPartnerId(bo.getPartnerId());
        teacherEntityExt.setPartnerIdSet(bo.getPartnerIdSet());
        if (bo.getPopularity() != Constant.DEFAULTNULL) {
        teacherEntityExt.setPopularity(bo.getPopularity());
        }
        teacherEntityExt.setPopularityEnd(bo.getPopularityEnd());
        teacherEntityExt.setPopularitySet(bo.getPopularitySet());
        teacherEntityExt.setPopularityStart(bo.getPopularityStart());
        return teacherEntityExt;
    }
}
