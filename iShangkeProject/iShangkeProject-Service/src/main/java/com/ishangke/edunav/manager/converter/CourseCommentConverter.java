package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.dataaccess.model.CourseCommentEntityExt;

public class CourseCommentConverter {
    public static CourseCommentBo toBo(CourseCommentEntityExt e) {
        CourseCommentBo courseCommentBo = new CourseCommentBo();
        courseCommentBo.setAttitudeRating(e.getAttitudeRating());
        courseCommentBo.setAttitudeRatingEnd(e.getAttitudeRatingEnd());
        courseCommentBo.setAttitudeRatingStart(e.getAttitudeRatingStart());
        courseCommentBo.setConditionRating(e.getConditionRating());
        courseCommentBo.setConditionRatingEnd(e.getConditionRatingEnd());
        courseCommentBo.setConditionRatingStart(e.getConditionRatingStart());
        courseCommentBo.setContent(e.getContent());
        courseCommentBo.setCourseTemplateId(e.getCourseTemplateId());
        courseCommentBo.setCourseTemplateIdSet(e.getCourseTemplateIdSet());
        courseCommentBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        courseCommentBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        courseCommentBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        courseCommentBo.setEnabled(e.getEnabled());
        courseCommentBo.setId(e.getId());
        courseCommentBo.setIdSet(e.getIdSet());
        courseCommentBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        courseCommentBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        courseCommentBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        courseCommentBo.setSatisfactionRating(e.getSatisfactionRating());
        courseCommentBo.setSatisfactionRatingEnd(e.getSatisfactionRatingEnd());
        courseCommentBo.setTotalRatingStart(e.getTotalRatingStart());
        courseCommentBo.setUserId(e.getUserId());
        courseCommentBo.setUserIdSet(e.getUserIdSet());
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
