package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ActivityBo;
import com.ishangke.edunav.dataaccess.model.ActivityEntityExt;

public class ActivityConverter {
    public static ActivityBo toBo(ActivityEntityExt e) {
        ActivityBo activityBo = new ActivityBo();
        if (e.getCourseId() != null) {
            activityBo.setCourseId(e.getCourseId());
        }
        if (e.getCourseIdSet() != null) {
            activityBo.setCourseIdSet(e.getCourseIdSet());
        }
        if (e.getEnabled() != null) {
            activityBo.setEnabled(e.getEnabled());
        }
        if (e.getStatus() != null) {
            activityBo.setStatus(e.getStatus());
        }
        if (e.getStatusSet() != null) {
            activityBo.setStatusSet(e.getStatusSet());
        }
        activityBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        activityBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        activityBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        activityBo.setEndTime(e.getEndTime() == null ? Constant.DEFAULTNULL : e.getEndTime().getTimeInMillis());
        activityBo.setEndTimeEnd(e.getEndTimeEnd() == null ? Constant.DEFAULTNULL : e.getEndTimeEnd().getTimeInMillis());
        activityBo.setEndTimeStart(e.getEndTimeStart() == null ? Constant.DEFAULTNULL : e.getEndTimeStart().getTimeInMillis());
        return activityBo;
    }

    public static ActivityEntityExt fromBo(ActivityBo bo) {
        ActivityEntityExt activityEntityExt = new ActivityEntityExt();
        activityEntityExt.setCourseId(bo.getCourseId());
        activityEntityExt.setCourseIdSet(bo.getCourseIdSet());
        activityEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        activityEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        activityEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        activityEntityExt.setEnabled(bo.getEnabled());
        activityEntityExt.setEndTime(DateUtility.getTimeFromLong(bo.getEndTime()));
        activityEntityExt.setEndTimeEnd(DateUtility.getTimeFromLong(bo.getEndTimeEnd()));
        activityEntityExt.setEndTimeStart(DateUtility.getTimeFromLong(bo.getEndTimeStart()));
        activityEntityExt.setStatus(bo.getStatus());
        activityEntityExt.setStatusSet(bo.getStatusSet());
        return activityEntityExt;
    }
}
