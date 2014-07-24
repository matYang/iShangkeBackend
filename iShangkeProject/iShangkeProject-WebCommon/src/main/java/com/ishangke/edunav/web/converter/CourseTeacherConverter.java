package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseTeacherBo;
import com.ishangke.edunav.web.model.CourseTeacherVo;

public class CourseTeacherConverter {
    public static CourseTeacherBo fromModel(CourseTeacherVo vo) {
        CourseTeacherBo courseTeacherBo = new CourseTeacherBo();
        courseTeacherBo.setCourseId(vo.getCourseId());
        courseTeacherBo.setCourseIdSet(vo.getCourseIdSet());
        courseTeacherBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        courseTeacherBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        courseTeacherBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        courseTeacherBo.setId(vo.getId());
        courseTeacherBo.setIdSet(vo.getIdSet());
        courseTeacherBo.setTeacherId(vo.getTeacherId());
        courseTeacherBo.setTeacherIdSet(vo.getTeacherIdSet());
        return courseTeacherBo;
    }

    public static CourseTeacherVo toModel(CourseTeacherBo bo) {
        CourseTeacherVo courseTeacherVo = new CourseTeacherVo();
        courseTeacherVo.setCourseId(bo.getCourseId());
        courseTeacherVo.setCourseIdSet(bo.getCourseIdSet());
        courseTeacherVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        courseTeacherVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        courseTeacherVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        courseTeacherVo.setId(bo.getId());
        courseTeacherVo.setIdSet(bo.getIdSet());
        courseTeacherVo.setTeacherId(bo.getTeacherId());
        courseTeacherVo.setTeacherIdSet(bo.getTeacherIdSet());
        return courseTeacherVo;
    }
}
