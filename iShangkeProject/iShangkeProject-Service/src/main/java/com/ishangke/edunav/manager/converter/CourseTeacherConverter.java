package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseTeacherBo;
import com.ishangke.edunav.dataaccess.model.CourseTeacherEntityExt;

public class CourseTeacherConverter {
    public static CourseTeacherBo toBo(CourseTeacherEntityExt e) {
        CourseTeacherBo courseTeacherBo = new CourseTeacherBo();
        if (e.getCourseId() != null) {
            courseTeacherBo.setCourseId(e.getCourseId());
        }
        if (e.getCourseIdSet() != null) {
            courseTeacherBo.setCourseIdSet(e.getCourseIdSet());
        }
        if (e.getId() != null) {
            courseTeacherBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            courseTeacherBo.setIdSet(e.getIdSet());
        }
        if (e.getTeacherId() != null) {
            courseTeacherBo.setTeacherId(e.getTeacherId());
        }
        if (e.getTeacherIdSet() != null) {
            courseTeacherBo.setTeacherIdSet(e.getTeacherIdSet());
        }
        courseTeacherBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        courseTeacherBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        courseTeacherBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        return courseTeacherBo;
    }

    public static CourseTeacherEntityExt fromBo(CourseTeacherBo bo) {
        CourseTeacherEntityExt courseTeacherEntityExt = new CourseTeacherEntityExt();
        courseTeacherEntityExt.setCourseId(bo.getCourseId());
        courseTeacherEntityExt.setCourseIdSet(bo.getCourseIdSet());
        courseTeacherEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        courseTeacherEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        courseTeacherEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        courseTeacherEntityExt.setId(bo.getId());
        courseTeacherEntityExt.setIdSet(bo.getIdSet());
        courseTeacherEntityExt.setTeacherId(bo.getTeacherId());
        courseTeacherEntityExt.setTeacherIdSet(bo.getTeacherIdSet());
        return courseTeacherEntityExt;
    }
}
