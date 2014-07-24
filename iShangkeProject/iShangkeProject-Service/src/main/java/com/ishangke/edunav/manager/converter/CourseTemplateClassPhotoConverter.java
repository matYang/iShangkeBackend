package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseTemplateClassPhotoBo;
import com.ishangke.edunav.dataaccess.model.CourseTemplateClassPhotoEntityExt;

public class CourseTemplateClassPhotoConverter {
    public static CourseTemplateClassPhotoBo toBo(CourseTemplateClassPhotoEntityExt e) {
        CourseTemplateClassPhotoBo courseTemplateClassPhotoBo = new CourseTemplateClassPhotoBo();
        courseTemplateClassPhotoBo.setClassPhotoId(e.getClassPhotoId());
        courseTemplateClassPhotoBo.setClassPhotoIdSet(e.getClassPhotoIdSet());
        courseTemplateClassPhotoBo.setCourseTemplateId(e.getCourseTemplateId());
        courseTemplateClassPhotoBo.setCourseTemplateIdSet(e.getCourseTemplateIdSet());
        courseTemplateClassPhotoBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        courseTemplateClassPhotoBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        courseTemplateClassPhotoBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
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
