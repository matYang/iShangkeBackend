package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.web.model.CourseCommentVo;

public class CourseCommentConverter {
    public static CourseCommentBo fromModel(CourseCommentVo vo) {
        if (vo == null) {
            return null;
        }
        CourseCommentBo courseCommentBo = new CourseCommentBo();
        if (vo.getAttitudeRating() != null) {
            courseCommentBo.setAttitudeRating(vo.getAttitudeRating());
        } else {
            courseCommentBo.setAttitudeRating(Constant.DEFAULTNULL);
        }
        if (vo.getAttitudeRatingEnd() != null) {
            courseCommentBo.setAttitudeRatingEnd(vo.getAttitudeRatingEnd());
        } else {
            courseCommentBo.setAttitudeRatingEnd(Constant.DEFAULTNULL);
        }
        if (vo.getAttitudeRatingStart() != null) {
            courseCommentBo.setAttitudeRatingStart(vo.getAttitudeRatingStart());
        } else {
            courseCommentBo.setAttitudeRatingStart(Constant.DEFAULTNULL);
        }
        if (vo.getConditionRating() != null) {
            courseCommentBo.setConditionRating(vo.getConditionRating());
        } else {
            courseCommentBo.setConditionRating(Constant.DEFAULTNULL);
        }
        if (vo.getConditionRatingEnd() != null) {
            courseCommentBo.setConditionRatingEnd(vo.getConditionRatingEnd());
        } else {
            courseCommentBo.setConditionRatingEnd(Constant.DEFAULTNULL);
        }
        if (vo.getConditionRatingStart() != null) {
            courseCommentBo.setConditionRatingStart(vo.getConditionRatingStart());
        } else {
            courseCommentBo.setConditionRatingStart(Constant.DEFAULTNULL);
        }
        if (vo.getContent() != null) {
            courseCommentBo.setContent(vo.getContent());
        }
        if (vo.getCourseTemplateId() != null) {
            courseCommentBo.setCourseTemplateId(vo.getCourseTemplateId());
        }
        if (vo.getCourseTemplateIdSet() != null) {
            courseCommentBo.setCourseTemplateIdSet(vo.getCourseTemplateIdSet());
        }
        if (vo.getEnabled() != null) {
            courseCommentBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            courseCommentBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            courseCommentBo.setIdSet(vo.getIdSet());
        }
        if (vo.getSatisfactionRating() != null) {
            courseCommentBo.setSatisfactionRating(vo.getSatisfactionRating());
        } else {
            courseCommentBo.setSatisfactionRating(Constant.DEFAULTNULL);
        }
        if (vo.getSatisfactionRatingEnd() != null) {
            courseCommentBo.setSatisfactionRatingEnd(vo.getSatisfactionRatingEnd());
        } else {
            courseCommentBo.setSatisfactionRatingEnd(Constant.DEFAULTNULL);
        }
        if (vo.getSatisfactionRatingStart() != null) {
            courseCommentBo.setSatisfactionRatingStart(vo.getSatisfactionRatingStart());
        } else {
            courseCommentBo.setSatisfactionRatingStart(Constant.DEFAULTNULL);
        }
        if (vo.getTotalRating() != null) {
            courseCommentBo.setTotalRating(vo.getTotalRating());
        } else {
            courseCommentBo.setTotalRating(Constant.DEFAULTNULL);
        }
        if (vo.getTotalRatingEnd() != null) {
            courseCommentBo.setTotalRatingEnd(vo.getTotalRatingEnd());
        } else {
            courseCommentBo.setTotalRatingEnd(Constant.DEFAULTNULL);
        }
        if (vo.getTotalRatingStart() != null) {
            courseCommentBo.setTotalRatingStart(vo.getTotalRatingStart());
        } else {
            courseCommentBo.setTotalRatingStart(Constant.DEFAULTNULL);
        }
        if (vo.getUserId() != null) {
            courseCommentBo.setUserId(vo.getUserId());
        }
        if (vo.getUserIdSet() != null) {
            courseCommentBo.setUserIdSet(vo.getUserIdSet());
        }
        if (vo.getCreateTime() != null) {
            courseCommentBo.setCreateTime(vo.getCreateTime());
        } else {
            courseCommentBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            courseCommentBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            courseCommentBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            courseCommentBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            courseCommentBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            courseCommentBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            courseCommentBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            courseCommentBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            courseCommentBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            courseCommentBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            courseCommentBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return courseCommentBo;
    }

    public static CourseCommentVo toModel(CourseCommentBo bo) {
        if (bo == null) {
            return null;
        }
        CourseCommentVo courseCommentVo = new CourseCommentVo();
        if (Constant.DEFAULTNULL != bo.getAttitudeRating()) {
            courseCommentVo.setAttitudeRating(bo.getAttitudeRating());
        }
        if (Constant.DEFAULTNULL != bo.getAttitudeRatingEnd()) {
            courseCommentVo.setAttitudeRatingEnd(bo.getAttitudeRatingEnd());
        }
        if (Constant.DEFAULTNULL != bo.getAttitudeRatingStart()) {
            courseCommentVo.setAttitudeRatingStart(bo.getAttitudeRatingStart());
        }
        if (Constant.DEFAULTNULL != bo.getConditionRating()) {
            courseCommentVo.setConditionRating(bo.getConditionRating());
        }
        if (Constant.DEFAULTNULL != bo.getConditionRatingEnd()) {
            courseCommentVo.setConditionRatingEnd(bo.getConditionRatingEnd());
        }
        if (Constant.DEFAULTNULL != bo.getConditionRatingStart()) {
            courseCommentVo.setConditionRatingStart(bo.getConditionRatingStart());
        }
        courseCommentVo.setContent(bo.getContent());
        courseCommentVo.setCourseTemplateId(bo.getCourseTemplateId());
//        courseCommentVo.setCourseTemplateIdSet(bo.getCourseTemplateIdSet());
        courseCommentVo.setCreateTime(bo.getCreateTime());
//        courseCommentVo.setCreateTimeEnd(bo.getCreateTimeEnd());
//        courseCommentVo.setCreateTimeStart(bo.getCreateTimeStart());
        courseCommentVo.setEnabled(bo.getEnabled());
        courseCommentVo.setId(bo.getId());
//        courseCommentVo.setIdSet(bo.getIdSet());
        courseCommentVo.setLastModifyTime(bo.getLastModifyTime());
//        courseCommentVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
//        courseCommentVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        if (Constant.DEFAULTNULL != bo.getSatisfactionRating()) {
            courseCommentVo.setSatisfactionRating(bo.getSatisfactionRating());
        }
        if (Constant.DEFAULTNULL != bo.getSatisfactionRatingEnd()) {
            courseCommentVo.setSatisfactionRatingEnd(bo.getSatisfactionRatingEnd());
        }
        if (Constant.DEFAULTNULL != bo.getSatisfactionRatingStart()) {
            courseCommentVo.setSatisfactionRatingStart(bo.getSatisfactionRatingStart());
        }
        if (Constant.DEFAULTNULL != bo.getTotalRating()) {
            courseCommentVo.setTotalRating(bo.getTotalRating());
        }
        if (Constant.DEFAULTNULL != bo.getTotalRatingEnd()) {
            courseCommentVo.setTotalRatingEnd(bo.getTotalRatingEnd());
        }
        if (Constant.DEFAULTNULL != bo.getTotalRatingStart()) {
            courseCommentVo.setTotalRatingStart(bo.getTotalRatingStart());
        }
        courseCommentVo.setUserId(bo.getUserId());
//        courseCommentVo.setUserIdSet(bo.getUserIdSet());
        return courseCommentVo;
    }
}
