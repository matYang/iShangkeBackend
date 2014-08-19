package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.web.model.TeacherVo;

public class TeacherConverter {
    public static TeacherBo fromModel(TeacherVo vo) {
        if (vo == null) {
            return null;
        }
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
        } else {
            teacherBo.setPopularity(Constant.DEFAULTNULL);
        }
        if (vo.getPopularityEnd() != null) {
            teacherBo.setPopularityEnd(vo.getPopularityEnd());
        } else {
            teacherBo.setPopularityEnd(Constant.DEFAULTNULL);
        }
        if (vo.getPopularitySet() != null) {
            teacherBo.setPopularitySet(vo.getPopularitySet());
        }
        if (vo.getPopularityStart() != null) {
            teacherBo.setPopularityStart(vo.getPopularityStart());
        } else {
            teacherBo.setPopularityStart(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTime() != null) {
            teacherBo.setCreateTime(vo.getCreateTime());
        } else {
            teacherBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            teacherBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            teacherBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            teacherBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            teacherBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            teacherBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            teacherBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            teacherBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            teacherBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            teacherBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            teacherBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return teacherBo;
    }

    public static TeacherVo toModel(TeacherBo bo) {
        if (bo == null) {
            return null;
        }
        TeacherVo teacherVo = new TeacherVo();
        teacherVo.setCreateTime(bo.getCreateTime());
        // teacherVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        // teacherVo.setCreateTimeStart(bo.getCreateTimeStart());
        teacherVo.setEnabled(bo.getEnabled());
        teacherVo.setId(bo.getId());
        // teacherVo.setIdSet(bo.getIdSet());
        teacherVo.setImgUrl(bo.getImgUrl());
        teacherVo.setIntro(bo.getIntro());
        teacherVo.setLastModifyTime(bo.getLastModifyTime());
        // teacherVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
        // teacherVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        teacherVo.setName(bo.getName());
        teacherVo.setPartnerId(bo.getPartnerId());
        // teacherVo.setPartnerIdSet(bo.getPartnerIdSet());
        if (Constant.DEFAULTNULL != bo.getPopularity()) {
            teacherVo.setPopularity(bo.getPopularity());
        }
        // teacherVo.setPopularityEnd(bo.getPopularityEnd());
        // teacherVo.setPopularitySet(bo.getPopularitySet());
        // teacherVo.setPopularityStart(bo.getPopularityStart());
        return teacherVo;
    }
}
