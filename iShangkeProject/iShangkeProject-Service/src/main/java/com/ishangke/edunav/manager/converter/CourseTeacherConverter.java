package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CourseTeacherBo;
import com.ishangke.edunav.dataaccess.model.CourseTeacherEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class CourseTeacherConverter {
    public static CourseTeacherBo toBo(CourseTeacherEntityExt e) {
        CourseTeacherBo courseTeacherBo = new CourseTeacherBo();
        courseTeacherBo.setCourseId(e.getCourseId());
        courseTeacherBo.setCourseIdSet(e.getCourseIdSet());
        courseTeacherBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        courseTeacherBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        courseTeacherBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        courseTeacherBo.setId(e.getId());
        courseTeacherBo.setIdSet(e.getIdSet());
        courseTeacherBo.setTeacherId(e.getTeacherId());
        courseTeacherBo.setTeacherIdSet(e.getTeacherIdSet());
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
