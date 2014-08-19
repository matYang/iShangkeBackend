package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
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
        if (vo.getCreateTime() != null) {
            activityBo.setCreateTime(vo.getCreateTime());
        } else {
            activityBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            activityBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            activityBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            activityBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            activityBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getEndTime() != null) {
            activityBo.setEndTime(vo.getEndTime());
        } else {
            activityBo.setEndTime(Constant.DEFAULTNULL);
        }
        if (vo.getEndTimeEnd() != null) {
            activityBo.setEndTimeEnd(vo.getEndTimeEnd());
        } else {
            activityBo.setEndTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getEndTimeStart() != null) {
            activityBo.setEndTimeStart(vo.getEndTimeStart());
        } else {
            activityBo.setEndTimeStart(Constant.DEFAULTNULL);
        }
        return activityBo;
    }

    public static ActivityVo toModel(ActivityBo bo) {
        if (bo == null) {
            return null;
        }
        ActivityVo activityVo = new ActivityVo();
        activityVo.setCourseId(bo.getCourseId());
//        activityVo.setCourseIdSet(bo.getCourseIdSet());
        activityVo.setCreateTime(bo.getCreateTime());
//        activityVo.setCreateTimeEnd(bo.getCreateTimeEnd());
//        activityVo.setCreateTimeStart(bo.getCreateTimeStart());
        activityVo.setEnabled(bo.getEnabled());
        activityVo.setEndTime(bo.getEndTime());
//        activityVo.setEndTimeEnd(bo.getEndTimeEnd());
//        activityVo.setEndTimeStart(bo.getEndTimeStart());
        if (Constant.DEFAULTNULL != bo.getStatus()) {
            activityVo.setStatus(bo.getStatus());
        }
//        activityVo.setStatusSet(bo.getStatusSet());
        return activityVo;
    }
}
