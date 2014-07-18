package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CourseTemplateClassPhotoBo;
import com.ishangke.edunav.dataaccess.model.CourseTemplateClassPhotoEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class CourseTemplateClassPhotoConverter {
    public static CourseTemplateClassPhotoBo toBo(CourseTemplateClassPhotoEntityExt e) {
        CourseTemplateClassPhotoBo courseTemplateClassPhotoBo = new CourseTemplateClassPhotoBo();
        courseTemplateClassPhotoBo.setClassPhotoId(e.getClassPhotoId());
        courseTemplateClassPhotoBo.setClassPhotoIdSet(e.getClassPhotoIdSet());
        courseTemplateClassPhotoBo.setCourseTemplateId(e.getCourseTemplateId());
        courseTemplateClassPhotoBo.setCourseTemplateIdSet(e.getCourseTemplateIdSet());
        courseTemplateClassPhotoBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        courseTemplateClassPhotoBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        courseTemplateClassPhotoBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        courseTemplateClassPhotoBo.setId(e.getId());
        courseTemplateClassPhotoBo.setIdSet(e.getIdSet());
        return courseTemplateClassPhotoBo;
    }

    public static CourseTemplateClassPhotoEntityExt fromBo(CourseTemplateClassPhotoBo bo) {
        CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt = new CourseTemplateClassPhotoEntityExt();
        courseTemplateClassPhotoEntityExt.setClassPhotoId(bo.getClassPhotoId());
        courseTemplateClassPhotoEntityExt.setClassPhotoIdSet(bo.getClassPhotoIdSet());
        courseTemplateClassPhotoEntityExt.setCourseTemplateId(bo.getCourseTemplateId());
        courseTemplateClassPhotoEntityExt.setCourseTemplateIdSet(bo.getCourseTemplateIdSet());
        courseTemplateClassPhotoEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        courseTemplateClassPhotoEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        courseTemplateClassPhotoEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        courseTemplateClassPhotoEntityExt.setId(bo.getId());
        courseTemplateClassPhotoEntityExt.setIdSet(bo.getIdSet());
        return courseTemplateClassPhotoEntityExt;
    }
}
