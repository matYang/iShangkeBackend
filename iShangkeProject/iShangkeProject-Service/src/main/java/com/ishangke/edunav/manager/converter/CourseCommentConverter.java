package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.dataaccess.model.CourseCommentEntityExt;

public class CourseCommentConverter {
    public static CourseCommentBo toBo(CourseCommentEntityExt e) {
        CourseCommentBo courseCommentBo = new CourseCommentBo();
        if (e.getAttitudeRating() != null) {
            courseCommentBo.setAttitudeRating(e.getAttitudeRating());
        }
        if (e.getAttitudeRatingEnd() != null) {
            courseCommentBo.setAttitudeRatingEnd(e.getAttitudeRatingEnd());
        }
        if (e.getAttitudeRatingStart() != null) {
            courseCommentBo.setAttitudeRatingStart(e.getAttitudeRatingStart());
        }
        if (e.getConditionRating() != null) {
            courseCommentBo.setConditionRating(e.getConditionRating());
        }
        if (e.getConditionRatingEnd() != null) {
            courseCommentBo.setConditionRatingEnd(e.getConditionRatingEnd());
        }
        if (e.getConditionRatingStart() != null) {
            courseCommentBo.setConditionRatingStart(e.getConditionRatingStart());
        }
        if (e.getContent() != null) {
            courseCommentBo.setContent(e.getContent());
        }
        if (e.getCourseTemplateId() != null) {
            courseCommentBo.setCourseTemplateId(e.getCourseTemplateId());
        }
        if (e.getCourseTemplateIdSet() != null) {
            courseCommentBo.setCourseTemplateIdSet(e.getCourseTemplateIdSet());
        }
        if (e.getEnabled() != null) {
            courseCommentBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            courseCommentBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            courseCommentBo.setIdSet(e.getIdSet());
        }
        if (e.getSatisfactionRating() != null) {
            courseCommentBo.setSatisfactionRating(e.getSatisfactionRating());
        }
        if (e.getSatisfactionRatingEnd() != null) {
            courseCommentBo.setSatisfactionRatingEnd(e.getSatisfactionRatingEnd());
        }
        if (e.getTotalRatingStart() != null) {
            courseCommentBo.setTotalRatingStart(e.getTotalRatingStart());
        }
        if (e.getUserId() != null) {
            courseCommentBo.setUserId(e.getUserId());
        }
        if (e.getUserIdSet() != null) {
            courseCommentBo.setUserIdSet(e.getUserIdSet());
        }
        courseCommentBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        courseCommentBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        courseCommentBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        courseCommentBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        courseCommentBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        courseCommentBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        return courseCommentBo;
    }

    public static CourseCommentEntityExt fromBo(CourseCommentBo bo) {
        CourseCommentEntityExt courseCommentEntityExt = new CourseCommentEntityExt();
        courseCommentEntityExt.setAttitudeRating(bo.getAttitudeRating());
        courseCommentEntityExt.setAttitudeRatingEnd(bo.getAttitudeRatingEnd());
        courseCommentEntityExt.setAttitudeRatingStart(bo.getAttitudeRatingStart());
        courseCommentEntityExt.setConditionRating(bo.getConditionRating());
        courseCommentEntityExt.setConditionRatingEnd(bo.getConditionRatingEnd());
        courseCommentEntityExt.setConditionRatingStart(bo.getConditionRatingStart());
        courseCommentEntityExt.setContent(bo.getContent());
        courseCommentEntityExt.setCourseTemplateId(bo.getCourseTemplateId());
        courseCommentEntityExt.setCourseTemplateIdSet(bo.getCourseTemplateIdSet());
        courseCommentEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        courseCommentEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        courseCommentEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        courseCommentEntityExt.setEnabled(bo.getEnabled());
        courseCommentEntityExt.setId(bo.getId());
        courseCommentEntityExt.setIdSet(bo.getIdSet());
        courseCommentEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        courseCommentEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        courseCommentEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        courseCommentEntityExt.setSatisfactionRating(bo.getSatisfactionRating());
        courseCommentEntityExt.setSatisfactionRatingEnd(bo.getSatisfactionRatingEnd());
        courseCommentEntityExt.setTotalRatingStart(bo.getTotalRatingStart());
        courseCommentEntityExt.setUserId(bo.getUserId());
        courseCommentEntityExt.setUserIdSet(bo.getUserIdSet());
        return courseCommentEntityExt;
    }
}
