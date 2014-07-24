package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;

public class TeacherConverter {
    public static TeacherBo toBo(TeacherEntityExt e) {
        TeacherBo teacherBo = new TeacherBo();
        teacherBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        teacherBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        teacherBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        teacherBo.setEnabled(e.getEnabled());
        teacherBo.setId(e.getId());
        teacherBo.setIdSet(e.getIdSet());
        teacherBo.setImgUrl(e.getImgUrl());
        teacherBo.setIntro(e.getIntro());
        teacherBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        teacherBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        teacherBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        teacherBo.setName(e.getName());
        teacherBo.setPartnerId(e.getPartnerId());
        teacherBo.setPartnerIdSet(e.getPartnerIdSet());
        teacherBo.setPopularity(e.getPopularity());
        teacherBo.setPopularityEnd(e.getPopularityEnd());
        teacherBo.setPopularitySet(e.getPopularitySet());
        teacherBo.setPopularityStart(e.getPopularityStart());
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
        teacherEntityExt.setPopularity(bo.getPopularity());
        teacherEntityExt.setPopularityEnd(bo.getPopularityEnd());
        teacherEntityExt.setPopularitySet(bo.getPopularitySet());
        teacherEntityExt.setPopularityStart(bo.getPopularityStart());
        return teacherEntityExt;
    }
}
