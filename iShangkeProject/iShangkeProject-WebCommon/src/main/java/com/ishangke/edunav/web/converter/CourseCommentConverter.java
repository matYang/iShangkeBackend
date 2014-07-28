package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
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
        courseCommentBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime()
                .getTimeInMillis());
        courseCommentBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd()
                .getTimeInMillis());
        courseCommentBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getCreateTimeStart().getTimeInMillis());
        courseCommentBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTime().getTimeInMillis());
        courseCommentBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeEnd().getTimeInMillis());
        courseCommentBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeStart().getTimeInMillis());
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
        courseCommentVo.setUserIdSet(bo.getUserIdSet());
        return courseCommentVo;
    }
}
