package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseTemplateTeacherBo;
import com.ishangke.edunav.dataaccess.model.CourseTemplateTeacherEntityExt;

public class CourseTemplateTeacherConverter {
    public static CourseTemplateTeacherBo toBo(CourseTemplateTeacherEntityExt e) {
        if (e == null) {
            return null;
        }
        CourseTemplateTeacherBo courseTemplateTeacherBo = new CourseTemplateTeacherBo();
        if (e.getCourseTemplateId() != null) {
            courseTemplateTeacherBo.setCourseTemplateId(e.getCourseTemplateId());
        }
        if (e.getCourseTemplateIdSet() != null) {
            courseTemplateTeacherBo.setCourseTemplateIdSet(e.getCourseTemplateIdSet());
        }
        if (e.getId() != null) {
            courseTemplateTeacherBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            courseTemplateTeacherBo.setIdSet(e.getIdSet());
        }
        if (e.getTeacherId() != null) {
            courseTemplateTeacherBo.setTeacherId(e.getTeacherId());
        }
        if (e.getTeacherIdSet() != null) {
            courseTemplateTeacherBo.setTeacherIdSet(e.getTeacherIdSet());
        }
        courseTemplateTeacherBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime()
                .getTimeInMillis());
        courseTemplateTeacherBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getCreateTimeEnd().getTimeInMillis());
        courseTemplateTeacherBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e
                .getCreateTimeStart().getTimeInMillis());
        return courseTemplateTeacherBo;
    }

    public static CourseTemplateTeacherEntityExt fromBo(CourseTemplateTeacherBo bo) {
        if (bo == null) {
            return null;
        }
        CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt = new CourseTemplateTeacherEntityExt();
        courseTemplateTeacherEntityExt.setCourseTemplateId(bo.getCourseTemplateId());
        courseTemplateTeacherEntityExt.setCourseTemplateIdSet(bo.getCourseTemplateIdSet());
        courseTemplateTeacherEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        courseTemplateTeacherEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        courseTemplateTeacherEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        courseTemplateTeacherEntityExt.setId(bo.getId());
        courseTemplateTeacherEntityExt.setIdSet(bo.getIdSet());
        courseTemplateTeacherEntityExt.setTeacherId(bo.getTeacherId());
        courseTemplateTeacherEntityExt.setTeacherIdSet(bo.getTeacherIdSet());
        return courseTemplateTeacherEntityExt;
    }
}
