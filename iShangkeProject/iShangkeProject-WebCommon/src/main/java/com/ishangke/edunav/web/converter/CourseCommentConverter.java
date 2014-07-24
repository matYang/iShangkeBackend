package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.web.model.CourseCommentVo;

public class CourseCommentConverter {
    public static CourseCommentBo fromModel(CourseCommentVo vo) {
        CourseCommentBo courseCommentBo = new CourseCommentBo();
        if (vo.getAttitudeRating() != null) {
            courseCommentBo.setAttitudeRating(vo.getAttitudeRating());
        }
        if (vo.getAttitudeRatingEnd() != null) {
            courseCommentBo.setAttitudeRatingEnd(vo.getAttitudeRatingEnd());
        }
        if (vo.getAttitudeRatingStart() != null) {
            courseCommentBo.setAttitudeRatingStart(vo.getAttitudeRatingStart());
        }
        if (vo.getConditionRating() != null) {
            courseCommentBo.setConditionRating(vo.getConditionRating());
        }
        if (vo.getConditionRatingEnd() != null) {
            courseCommentBo.setConditionRatingEnd(vo.getConditionRatingEnd());
        }
        if (vo.getConditionRatingStart() != null) {
            courseCommentBo.setConditionRatingStart(vo.getConditionRatingStart());
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
        }
        if (vo.getSatisfactionRatingEnd() != null) {
            courseCommentBo.setSatisfactionRatingEnd(vo.getSatisfactionRatingEnd());
        }
        if (vo.getTotalRatingStart() != null) {
            courseCommentBo.setTotalRatingStart(vo.getTotalRatingStart());
        }
        if (vo.getUserId() != null) {
            courseCommentBo.setUserId(vo.getUserId());
        }
        if (vo.getUserIdSet() != null) {
            courseCommentBo.setUserIdSet(vo.getUserIdSet());
        }
        courseCommentBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        courseCommentBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        courseCommentBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        courseCommentBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        courseCommentBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        courseCommentBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        return courseCommentBo;
    }

    public static CourseCommentVo toModel(CourseCommentBo bo) {
        CourseCommentVo courseCommentVo = new CourseCommentVo();
        courseCommentVo.setAttitudeRating(bo.getAttitudeRating());
        courseCommentVo.setAttitudeRatingEnd(bo.getAttitudeRatingEnd());
        courseCommentVo.setAttitudeRatingStart(bo.getAttitudeRatingStart());
        courseCommentVo.setConditionRating(bo.getConditionRating());
        courseCommentVo.setConditionRatingEnd(bo.getConditionRatingEnd());
        courseCommentVo.setConditionRatingStart(bo.getConditionRatingStart());
        courseCommentVo.setContent(bo.getContent());
        courseCommentVo.setCourseTemplateId(bo.getCourseTemplateId());
        courseCommentVo.setCourseTemplateIdSet(bo.getCourseTemplateIdSet());
        courseCommentVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        courseCommentVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        courseCommentVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        courseCommentVo.setEnabled(bo.getEnabled());
        courseCommentVo.setId(bo.getId());
        courseCommentVo.setIdSet(bo.getIdSet());
        courseCommentVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        courseCommentVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        courseCommentVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        courseCommentVo.setSatisfactionRating(bo.getSatisfactionRating());
        courseCommentVo.setSatisfactionRatingEnd(bo.getSatisfactionRatingEnd());
        courseCommentVo.setTotalRatingStart(bo.getTotalRatingStart());
        courseCommentVo.setUserId(bo.getUserId());
        courseCommentVo.setUserIdSet(bo.getUserIdSet());
        return courseCommentVo;
    }
}
