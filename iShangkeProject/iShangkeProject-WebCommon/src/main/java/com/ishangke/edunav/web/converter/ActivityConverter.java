package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ActivityBo;
import com.ishangke.edunav.web.model.ActivityVo;

public class ActivityConverter {
    public static ActivityBo fromModel(ActivityVo vo) {
        if (vo == null) {
            return null;
        }
        ActivityBo activityBo = new ActivityBo();
        if (vo.getCourseId() != null) {
            activityBo.setCourseId(vo.getCourseId());
        }
        if (vo.getCourseIdSet() != null) {
            activityBo.setCourseIdSet(vo.getCourseIdSet());
        }
        if (vo.getEnabled() != null) {
            activityBo.setEnabled(vo.getEnabled());
        }
        if (vo.getStatus() != null) {
            activityBo.setStatus(vo.getStatus());
        } else {
            activityBo.setStatus(Constant.DEFAULTNULL);
        }
        if (vo.getStatusSet() != null) {
            activityBo.setStatusSet(vo.getStatusSet());
        }
        activityBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime()
                .getTimeInMillis());
        activityBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd()
                .getTimeInMillis());
        activityBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart()
                .getTimeInMillis());
        activityBo.setEndTime(vo.getEndTime() == null ? Constant.DEFAULTNULL : vo.getEndTime().getTimeInMillis());
        activityBo.setEndTimeEnd(vo.getEndTimeEnd() == null ? Constant.DEFAULTNULL : vo.getEndTimeEnd()
                .getTimeInMillis());
        activityBo.setEndTimeStart(vo.getEndTimeStart() == null ? Constant.DEFAULTNULL : vo.getEndTimeStart()
                .getTimeInMillis());
        return activityBo;
    }

    public static ActivityVo toModel(ActivityBo bo) {
        if (bo == null) {
            return null;
        }
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
        if (Constant.DEFAULTNULL != bo.getStatus()) {
            activityVo.setStatus(bo.getStatus());
        }
        activityVo.setStatusSet(bo.getStatusSet());
        return activityVo;
    }
}
