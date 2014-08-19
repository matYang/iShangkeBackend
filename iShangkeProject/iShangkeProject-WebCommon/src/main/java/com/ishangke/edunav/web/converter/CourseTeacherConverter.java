package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.CourseTeacherBo;
import com.ishangke.edunav.web.model.CourseTeacherVo;

public class CourseTeacherConverter {
    public static CourseTeacherBo fromModel(CourseTeacherVo vo) {
        if (vo == null) {
            return null;
        }
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
        if (vo.getCreateTime() != null) {
            courseTeacherBo.setCreateTime(vo.getCreateTime());
        } else {
            courseTeacherBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            courseTeacherBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            courseTeacherBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            courseTeacherBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            courseTeacherBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        return courseTeacherBo;
    }

    public static CourseTeacherVo toModel(CourseTeacherBo bo) {
        if (bo == null) {
            return null;
        }
        CourseTeacherVo courseTeacherVo = new CourseTeacherVo();
        courseTeacherVo.setCourseId(bo.getCourseId());
//        courseTeacherVo.setCourseIdSet(bo.getCourseIdSet());
        courseTeacherVo.setCreateTime(bo.getCreateTime());
//        courseTeacherVo.setCreateTimeEnd(bo.getCreateTimeEnd());
//        courseTeacherVo.setCreateTimeStart(bo.getCreateTimeStart());
        courseTeacherVo.setId(bo.getId());
//        courseTeacherVo.setIdSet(bo.getIdSet());
        courseTeacherVo.setTeacherId(bo.getTeacherId());
//        courseTeacherVo.setTeacherIdSet(bo.getTeacherIdSet());
        return courseTeacherVo;
    }
}
