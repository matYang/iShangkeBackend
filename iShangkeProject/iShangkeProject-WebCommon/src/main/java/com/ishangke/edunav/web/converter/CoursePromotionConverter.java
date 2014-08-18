package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.CoursePromotionBo;
import com.ishangke.edunav.web.model.CoursePromotionVo;

public class CoursePromotionConverter {
    public static CoursePromotionBo fromModel(CoursePromotionVo vo) {
        if (vo == null) {
            return null;
        }
        CoursePromotionBo coursePromotionBo = new CoursePromotionBo();
        if (vo.getId() != null) {
            coursePromotionBo.setId(vo.getId());
        }
        if (vo.getCourseId() != null) {
            coursePromotionBo.setCourseId(vo.getCourseId());
        }
        if (vo.getCategoryId() != null) {
            coursePromotionBo.setCategoryId(vo.getCategoryId());
        }
        if (vo.getCreateTime() != null) {
            coursePromotionBo.setCreateTime(vo.getCreateTime());
        } else {
            coursePromotionBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getStartTime() != null) {
            coursePromotionBo.setStartTime(vo.getStartTime());
        } else {
            coursePromotionBo.setStartTime(Constant.DEFAULTNULL);
        }
        if (vo.getEndTime() != null) {
            coursePromotionBo.setEndTime(vo.getEndTime());
        } else {
            coursePromotionBo.setEndTime(Constant.DEFAULTNULL);
        }
        if (vo.getStatus() != null) {
            coursePromotionBo.setStatus(vo.getStatus());
        } else {
            coursePromotionBo.setStatus(Constant.DEFAULTNULL);
        }
        
        
        if (vo.getCreateTimeStart() != null) {
            coursePromotionBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            coursePromotionBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            coursePromotionBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            coursePromotionBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        
        if (vo.getStartTimeStart() != null) {
            coursePromotionBo.setStartTimeStart(vo.getStartTimeStart());
        } else {
            coursePromotionBo.setStartTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getStartTimeEnd() != null) {
            coursePromotionBo.setStartTimeEnd(vo.getStartTimeEnd());
        } else {
            coursePromotionBo.setStartTimeEnd(Constant.DEFAULTNULL);
        }
        
        if (vo.getEndTimeStart() != null) {
            coursePromotionBo.setEndTimeStart(vo.getEndTimeStart());
        } else {
            coursePromotionBo.setEndTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getEndTimeEnd() != null) {
            coursePromotionBo.setEndTimeEnd(vo.getEndTimeEnd());
        } else {
            coursePromotionBo.setEndTimeEnd(Constant.DEFAULTNULL);
        }
        
        return coursePromotionBo;
    }

    public static CoursePromotionVo toModel(CoursePromotionBo bo) {
        if (bo == null) {
            return null;
        }
        CoursePromotionVo coursePromotionVo = new CoursePromotionVo();
        coursePromotionVo.setId(bo.getId());
        coursePromotionVo.setCourseId(bo.getCourseId());
        coursePromotionVo.setCategoryId(bo.getCategoryId());
        
        if (Constant.DEFAULTNULL != bo.getCreateTime()) {
            coursePromotionVo.setCreateTime(bo.getCreateTime());
        }
        if (Constant.DEFAULTNULL != bo.getStartTime()) {
            coursePromotionVo.setStartTime(bo.getStartTime());
        }
        if (Constant.DEFAULTNULL != bo.getEndTime()) {
            coursePromotionVo.setEndTime(bo.getEndTime());
        }
        if (Constant.DEFAULTNULL != bo.getStatus()) {
            coursePromotionVo.setStatus(bo.getStatus());
        }
        
        if (Constant.DEFAULTNULL != bo.getCreateTimeStart()) {
            coursePromotionVo.setCreateTimeStart(bo.getCreateTimeStart());
        }
        if (Constant.DEFAULTNULL != bo.getCreateTimeEnd()) {
            coursePromotionVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        }
        
        if (Constant.DEFAULTNULL != bo.getStartTimeStart()) {
            coursePromotionVo.setStartTimeStart(bo.getStartTimeStart());
        }
        if (Constant.DEFAULTNULL != bo.getStartTimeEnd()) {
            coursePromotionVo.setStartTimeEnd(bo.getStartTimeEnd());
        }
        
        if (Constant.DEFAULTNULL != bo.getEndTimeStart()) {
            coursePromotionVo.setEndTimeStart(bo.getEndTimeStart());
        }
        if (Constant.DEFAULTNULL != bo.getEndTimeEnd()) {
            coursePromotionVo.setEndTimeEnd(bo.getEndTimeEnd());
        }
        
        return coursePromotionVo;
    }
}
