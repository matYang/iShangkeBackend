package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.dataaccess.model.CourseCommentEntityExt;

public class CourseCommentConverter {
    public static CourseCommentBo toBo(CourseCommentEntityExt e) {
        if (e == null) {
            return null;
        }
        CourseCommentBo courseCommentBo = new CourseCommentBo();
        if (e.getAttitudeRating() != null) {
            courseCommentBo.setAttitudeRating(e.getAttitudeRating());
        } else {
            courseCommentBo.setAttitudeRating(Constant.DEFAULTNULL);
        }
        if (e.getAttitudeRatingEnd() != null) {
            courseCommentBo.setAttitudeRatingEnd(e.getAttitudeRatingEnd());
        } else {
            courseCommentBo.setAttitudeRatingEnd(Constant.DEFAULTNULL);
        }
        if (e.getAttitudeRatingStart() != null) {
            courseCommentBo.setAttitudeRatingStart(e.getAttitudeRatingStart());
        } else {
            courseCommentBo.setAttitudeRatingStart(Constant.DEFAULTNULL);
        }
        if (e.getConditionRating() != null) {
            courseCommentBo.setConditionRating(e.getConditionRating());
        } else {
            courseCommentBo.setConditionRating(Constant.DEFAULTNULL);
        }
        if (e.getConditionRatingEnd() != null) {
            courseCommentBo.setConditionRatingEnd(e.getConditionRatingEnd());
        } else {
            courseCommentBo.setConditionRatingEnd(Constant.DEFAULTNULL);
        }
        if (e.getConditionRatingStart() != null) {
            courseCommentBo.setConditionRatingStart(e.getConditionRatingStart());
        } else {
            courseCommentBo.setConditionRatingStart(Constant.DEFAULTNULL);
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
        } else {
            courseCommentBo.setSatisfactionRating(Constant.DEFAULTNULL);
        }
        if (e.getSatisfactionRatingEnd() != null) {
            courseCommentBo.setSatisfactionRatingEnd(e.getSatisfactionRatingEnd());
        } else {
            courseCommentBo.setSatisfactionRatingEnd(Constant.DEFAULTNULL);
        }
        if (e.getSatisfactionRatingStart() != null) {
            courseCommentBo.setSatisfactionRatingStart(e.getSatisfactionRatingStart());
        } else {
            courseCommentBo.setSatisfactionRatingStart(Constant.DEFAULTNULL);
        }
        if (e.getTotalRating() != null) {
            courseCommentBo.setTotalRating(e.getTotalRating());
        } else {
            courseCommentBo.setTotalRating(Constant.DEFAULTNULL);
        }
        if (e.getTotalRatingEnd() != null) {
            courseCommentBo.setTotalRatingEnd(e.getTotalRatingEnd());
        } else {
            courseCommentBo.setTotalRatingEnd(Constant.DEFAULTNULL);
        }
        if (e.getTotalRatingStart() != null) {
            courseCommentBo.setTotalRatingStart(e.getTotalRatingStart());
        } else {
            courseCommentBo.setTotalRatingStart(Constant.DEFAULTNULL);
        }
        if (e.getUserId() != null) {
            courseCommentBo.setUserId(e.getUserId());
        }
        if (e.getUserIdSet() != null) {
            courseCommentBo.setUserIdSet(e.getUserIdSet());
        }
        courseCommentBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime()
                .getTimeInMillis());
        courseCommentBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        courseCommentBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e
                .getCreateTimeStart().getTimeInMillis());
        courseCommentBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        courseCommentBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeEnd().getTimeInMillis());
        courseCommentBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        return courseCommentBo;
    }

    public static CourseCommentEntityExt fromBo(CourseCommentBo bo) {
        if (bo == null) {
            return null;
        }
        CourseCommentEntityExt courseCommentEntityExt = new CourseCommentEntityExt();
        if (bo.getAttitudeRating() != Constant.DEFAULTNULL) {
            courseCommentEntityExt.setAttitudeRating(bo.getAttitudeRating());
        }
        if (bo.getAttitudeRatingEnd() != Constant.DEFAULTNULL) {
            courseCommentEntityExt.setAttitudeRatingEnd(bo.getAttitudeRatingEnd());
        }
        if (bo.getAttitudeRatingStart() != Constant.DEFAULTNULL) {
            courseCommentEntityExt.setAttitudeRatingStart(bo.getAttitudeRatingStart());
        }
        if (bo.getConditionRating() != Constant.DEFAULTNULL) {
            courseCommentEntityExt.setConditionRating(bo.getConditionRating());
        }
        if (bo.getConditionRatingEnd() != Constant.DEFAULTNULL) {
            courseCommentEntityExt.setConditionRatingEnd(bo.getConditionRatingEnd());
        }
        if (bo.getConditionRatingStart() != Constant.DEFAULTNULL) {
            courseCommentEntityExt.setConditionRatingStart(bo.getConditionRatingStart());
        }
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
        if (bo.getSatisfactionRating() != Constant.DEFAULTNULL) {
            courseCommentEntityExt.setSatisfactionRating(bo.getSatisfactionRating());
        }
        if (bo.getSatisfactionRatingEnd() != Constant.DEFAULTNULL) {
            courseCommentEntityExt.setSatisfactionRatingEnd(bo.getSatisfactionRatingEnd());
        }
        if (bo.getSatisfactionRatingStart() != Constant.DEFAULTNULL) {
            courseCommentEntityExt.setSatisfactionRatingStart(bo.getSatisfactionRatingStart());
        }
        if (bo.getTotalRating() != Constant.DEFAULTNULL) {
            courseCommentEntityExt.setTotalRating(bo.getTotalRating());
        }
        if (bo.getTotalRatingEnd() != Constant.DEFAULTNULL) {
            courseCommentEntityExt.setTotalRatingEnd(bo.getTotalRatingEnd());
        }
        if (bo.getTotalRatingStart() != Constant.DEFAULTNULL) {
            courseCommentEntityExt.setTotalRatingStart(bo.getTotalRatingStart());
        }
        courseCommentEntityExt.setUserId(bo.getUserId());
        courseCommentEntityExt.setUserIdSet(bo.getUserIdSet());
        return courseCommentEntityExt;
    }
}
