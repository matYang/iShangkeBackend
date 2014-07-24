package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.web.model.CourseCommentVo;

public class CourseCommentConverter {
    public static CourseCommentBo fromModel(CourseCommentVo vo) {
        CourseCommentBo courseCommentBo = new CourseCommentBo();
        courseCommentBo.setAttitudeRating(vo.getAttitudeRating());
        courseCommentBo.setAttitudeRatingEnd(vo.getAttitudeRatingEnd());
        courseCommentBo.setAttitudeRatingStart(vo.getAttitudeRatingStart());
        courseCommentBo.setConditionRating(vo.getConditionRating());
        courseCommentBo.setConditionRatingEnd(vo.getConditionRatingEnd());
        courseCommentBo.setConditionRatingStart(vo.getConditionRatingStart());
        courseCommentBo.setContent(vo.getContent());
        courseCommentBo.setCourseTemplateId(vo.getCourseTemplateId());
        courseCommentBo.setCourseTemplateIdSet(vo.getCourseTemplateIdSet());
        courseCommentBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        courseCommentBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        courseCommentBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        courseCommentBo.setEnabled(vo.getEnabled());
        courseCommentBo.setId(vo.getId());
        courseCommentBo.setIdSet(vo.getIdSet());
        courseCommentBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        courseCommentBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        courseCommentBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        courseCommentBo.setSatisfactionRating(vo.getSatisfactionRating());
        courseCommentBo.setSatisfactionRatingEnd(vo.getSatisfactionRatingEnd());
        courseCommentBo.setTotalRatingStart(vo.getTotalRatingStart());
        courseCommentBo.setUserId(vo.getUserId());
        courseCommentBo.setUserIdSet(vo.getUserIdSet());
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
