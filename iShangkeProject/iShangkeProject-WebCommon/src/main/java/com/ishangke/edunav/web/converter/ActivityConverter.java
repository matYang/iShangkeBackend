package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ActivityBo;
import com.ishangke.edunav.web.model.ActivityVo;

public class ActivityConverter {
    public static ActivityBo fromModel(ActivityVo vo) {
        ActivityBo activityBo = new ActivityBo();
        activityBo.setCourseId(vo.getCourseId());
        activityBo.setCourseIdSet(vo.getCourseIdSet());
        activityBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        activityBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        activityBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        activityBo.setEnabled(vo.getEnabled());
        activityBo.setEndTime(vo.getEndTime() == null ? Constant.DEFAULTNULL : vo.getEndTime().getTimeInMillis());
        activityBo.setEndTimeEnd(vo.getEndTimeEnd() == null ? Constant.DEFAULTNULL : vo.getEndTimeEnd().getTimeInMillis());
        activityBo.setEndTimeStart(vo.getEndTimeStart() == null ? Constant.DEFAULTNULL : vo.getEndTimeStart().getTimeInMillis());
        activityBo.setStatus(vo.getStatus());
        activityBo.setStatusSet(vo.getStatusSet());
        return activityBo;
    }

    public static ActivityVo toModel(ActivityBo bo) {
        ActivityVo activityVo = new ActivityVo();
        activityVo.setCourseId(bo.getCourseId());
        activityVo.setCourseIdSet(bo.getCourseIdSet());
        activityVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        activityVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        activityVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        activityVo.setEnabled(bo.getEnabled());
        activityVo.setEndTime(DateUtility.getTimeFromLong(bo.getEndTime()));
        activityVo.setEndTimeEnd(DateUtility.getTimeFromLong(bo.getEndTimeEnd()));
        activityVo.setEndTimeStart(DateUtility.getTimeFromLong(bo.getEndTimeStart()));
        activityVo.setStatus(bo.getStatus());
        activityVo.setStatusSet(bo.getStatusSet());
        return activityVo;
    }
}
