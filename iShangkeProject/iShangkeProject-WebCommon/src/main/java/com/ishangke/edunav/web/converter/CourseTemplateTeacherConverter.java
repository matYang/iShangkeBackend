package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
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
        courseTemplateTeacherBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime()
                .getTimeInMillis());
        courseTemplateTeacherBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo
                .getCreateTimeEnd().getTimeInMillis());
        courseTemplateTeacherBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getCreateTimeStart().getTimeInMillis());
        return courseTemplateTeacherBo;
    }

    public static CourseTemplateTeacherVo toModel(CourseTemplateTeacherBo bo) {

        if (bo == null) {
            return null;
        }
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
