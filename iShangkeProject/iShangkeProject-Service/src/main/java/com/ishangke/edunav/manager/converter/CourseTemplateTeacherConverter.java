package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseTemplateTeacherBo;
import com.ishangke.edunav.dataaccess.model.CourseTemplateTeacherEntityExt;

public class CourseTemplateTeacherConverter {
    public static CourseTemplateTeacherBo toBo(CourseTemplateTeacherEntityExt e) {
        CourseTemplateTeacherBo courseTemplateTeacherBo = new CourseTemplateTeacherBo();
        courseTemplateTeacherBo.setCourseTemplateId(e.getCourseTemplateId());
        courseTemplateTeacherBo.setCourseTemplateIdSet(e.getCourseTemplateIdSet());
        courseTemplateTeacherBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        courseTemplateTeacherBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        courseTemplateTeacherBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        courseTemplateTeacherBo.setId(e.getId());
        courseTemplateTeacherBo.setIdSet(e.getIdSet());
        courseTemplateTeacherBo.setTeacherId(e.getTeacherId());
        courseTemplateTeacherBo.setTeacherIdSet(e.getTeacherIdSet());
        return courseTemplateTeacherBo;
    }

    public static CourseTemplateTeacherEntityExt fromBo(CourseTemplateTeacherBo bo) {
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
