package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.CourseTemplateTeacherBo;
import com.ishangke.edunav.web.model.CourseTemplateTeacherVo;
import com.ishangke.edunav.web.common.DateUtility;

public class CourseTemplateTeacherConverter {
    public static CourseTemplateTeacherBo fromModel(CourseTemplateTeacherVo vo) {
        CourseTemplateTeacherBo courseTemplateTeacherBo = new CourseTemplateTeacherBo();
        courseTemplateTeacherBo.setCourseTemplateId(vo.getCourseTemplateId());
        courseTemplateTeacherBo.setCourseTemplateIdSet(vo.getCourseTemplateIdSet());
        courseTemplateTeacherBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        courseTemplateTeacherBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        courseTemplateTeacherBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        courseTemplateTeacherBo.setId(vo.getId());
        courseTemplateTeacherBo.setIdSet(vo.getIdSet());
        courseTemplateTeacherBo.setTeacherId(vo.getTeacherId());
        courseTemplateTeacherBo.setTeacherIdSet(vo.getTeacherIdSet());
        return courseTemplateTeacherBo;
    }

    public static CourseTemplateTeacherVo toModel(CourseTemplateTeacherBo bo) {
        CourseTemplateTeacherVo courseTemplateTeacherVo = new CourseTemplateTeacherVo();
        courseTemplateTeacherVo.setCourseTemplateId(bo.getCourseTemplateId());
        courseTemplateTeacherVo.setCourseTemplateIdSet(bo.getCourseTemplateIdSet());
        courseTemplateTeacherVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        courseTemplateTeacherVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        courseTemplateTeacherVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        courseTemplateTeacherVo.setId(bo.getId());
        courseTemplateTeacherVo.setIdSet(bo.getIdSet());
        courseTemplateTeacherVo.setTeacherId(bo.getTeacherId());
        courseTemplateTeacherVo.setTeacherIdSet(bo.getTeacherIdSet());
        return courseTemplateTeacherVo;
    }
}
