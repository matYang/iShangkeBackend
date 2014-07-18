package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.ActivityBo;
import com.ishangke.edunav.dataaccess.model.ActivityEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class ActivityConverter {
    public static ActivityBo toBo(ActivityEntityExt e) {
        ActivityBo activityBo = new ActivityBo();
        activityBo.setCourseId(e.getCourseId());
        activityBo.setCourseIdSet(e.getCourseIdSet());
        activityBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        activityBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        activityBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        activityBo.setEnabled(e.getEnabled());
        activityBo.setEndTime(e.getEndTime().getTimeInMillis());
        activityBo.setEndTimeEnd(e.getEndTimeEnd().getTimeInMillis());
        activityBo.setEndTimeStart(e.getEndTimeStart().getTimeInMillis());
        activityBo.setStatus(e.getStatus());
        activityBo.setStatusSet(e.getStatusSet());
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
