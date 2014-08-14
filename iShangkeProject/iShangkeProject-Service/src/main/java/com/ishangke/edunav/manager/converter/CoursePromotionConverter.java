package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CoursePromotionBo;
import com.ishangke.edunav.dataaccess.model.CoursePromotionEntityExt;

public class CoursePromotionConverter {
    public static CoursePromotionBo toBo(CoursePromotionEntityExt e) {
        if (e == null) {
            return null;
        }
        CoursePromotionBo bo = new CoursePromotionBo();
        if (e.getCategoryId() != null) {
            bo.setCategoryId(e.getCategoryId());
        }
        if (e.getCourseId() != null) {
            bo.setCourseId(e.getCourseId());
        }
        if (e.getId() != null) {
            bo.setId(e.getId());
        }
        if (e.getStatus() != null) {
            bo.setStatus(e.getStatus());
        } else {
            bo.setStatus(Constant.DEFAULTNULL);
        }
        bo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        bo.setEndTime(e.getEndTime() == null ? Constant.DEFAULTNULL : e.getEndTime().getTimeInMillis());
        bo.setStartTime(e.getStartTime() == null ? Constant.DEFAULTNULL : e.getStartTime().getTimeInMillis());
        bo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        bo.setEndTimeStart(e.getEndTimeStart() == null ? Constant.DEFAULTNULL : e.getEndTimeStart().getTimeInMillis());
        bo.setStartTimeStart(e.getStartTimeStart() == null ? Constant.DEFAULTNULL : e.getStartTimeStart().getTimeInMillis());
        bo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        bo.setEndTimeEnd(e.getEndTimeEnd() == null ? Constant.DEFAULTNULL : e.getEndTimeEnd().getTimeInMillis());
        bo.setStartTimeEnd(e.getStartTimeEnd() == null ? Constant.DEFAULTNULL : e.getStartTimeEnd().getTimeInMillis());
        return bo;
    }
    
    public static CoursePromotionEntityExt fromBo(CoursePromotionBo bo) {
        if (bo == null) {
            return null;
        }
        CoursePromotionEntityExt e = new CoursePromotionEntityExt();
        e.setCategoryId(bo.getCategoryId());
        e.setCourseId(bo.getCourseId());
        e.setId(bo.getId());
        if (bo.getStatus() != Constant.DEFAULTNULL) {
            e.setStatus(bo.getStatus());
        }
        e.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        e.setEndTime(DateUtility.getTimeFromLong(bo.getEndTime()));
        e.setStartTime(DateUtility.getTimeFromLong(bo.getStartTime()));
        e.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        e.setEndTimeStart(DateUtility.getTimeFromLong(bo.getEndTimeStart()));
        e.setStartTimeStart(DateUtility.getTimeFromLong(bo.getStartTimeStart()));
        e.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        e.setEndTimeEnd(DateUtility.getTimeFromLong(bo.getEndTimeEnd()));
        e.setStartTimeEnd(DateUtility.getTimeFromLong(bo.getStartTimeEnd()));
        return e;
    }
}
