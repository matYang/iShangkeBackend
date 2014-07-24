package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseTeacherBo;
import com.ishangke.edunav.web.model.CourseTeacherVo;

public class CourseTeacherConverter {
    public static CourseTeacherBo fromModel(CourseTeacherVo vo) {
        CourseTeacherBo courseTeacherBo = new CourseTeacherBo();
        if (vo.getCourseId() != null) {
            courseTeacherBo.setCourseId(vo.getCourseId());
        }
        if (vo.getCourseIdSet() != null) {
            courseTeacherBo.setCourseIdSet(vo.getCourseIdSet());
        }
        if (vo.getId() != null) {
            courseTeacherBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            courseTeacherBo.setIdSet(vo.getIdSet());
        }
        if (vo.getTeacherId() != null) {
            courseTeacherBo.setTeacherId(vo.getTeacherId());
        }
        if (vo.getTeacherIdSet() != null) {
            courseTeacherBo.setTeacherIdSet(vo.getTeacherIdSet());
        }
        courseTeacherBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        courseTeacherBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        courseTeacherBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
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
