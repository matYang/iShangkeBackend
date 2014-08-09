package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.CourseTemplateTeacherBo;
import com.ishangke.edunav.web.model.CourseTemplateTeacherVo;

public class CourseTemplateTeacherConverter {
    public static CourseTemplateTeacherBo fromModel(CourseTemplateTeacherVo vo) {
        if (vo == null) {
            return null;
        }
        CourseTemplateTeacherBo courseTemplateTeacherBo = new CourseTemplateTeacherBo();
        if (vo.getCourseTemplateId() != null) {
            courseTemplateTeacherBo.setCourseTemplateId(vo.getCourseTemplateId());
        }
        if (vo.getCourseTemplateIdSet() != null) {
            courseTemplateTeacherBo.setCourseTemplateIdSet(vo.getCourseTemplateIdSet());
        }
        if (vo.getId() != null) {
            courseTemplateTeacherBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            courseTemplateTeacherBo.setIdSet(vo.getIdSet());
        }
        if (vo.getTeacherId() != null) {
            courseTemplateTeacherBo.setTeacherId(vo.getTeacherId());
        }
        if (vo.getTeacherIdSet() != null) {
            courseTemplateTeacherBo.setTeacherIdSet(vo.getTeacherIdSet());
        }
        if (vo.getCreateTime() != null) {
            courseTemplateTeacherBo.setCreateTime(vo.getCreateTime());
        } else {
            courseTemplateTeacherBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            courseTemplateTeacherBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            courseTemplateTeacherBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            courseTemplateTeacherBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            courseTemplateTeacherBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        return courseTemplateTeacherBo;
    }

    public static CourseTemplateTeacherVo toModel(CourseTemplateTeacherBo bo) {

        if (bo == null) {
            return null;
        }
        CourseTemplateTeacherVo courseTemplateTeacherVo = new CourseTemplateTeacherVo();
        courseTemplateTeacherVo.setCourseTemplateId(bo.getCourseTemplateId());
        courseTemplateTeacherVo.setCourseTemplateIdSet(bo.getCourseTemplateIdSet());
        courseTemplateTeacherVo.setCreateTime(bo.getCreateTime());
        courseTemplateTeacherVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        courseTemplateTeacherVo.setCreateTimeStart(bo.getCreateTimeStart());
        courseTemplateTeacherVo.setId(bo.getId());
        courseTemplateTeacherVo.setIdSet(bo.getIdSet());
        courseTemplateTeacherVo.setTeacherId(bo.getTeacherId());
        courseTemplateTeacherVo.setTeacherIdSet(bo.getTeacherIdSet());
        return courseTemplateTeacherVo;
    }
}
