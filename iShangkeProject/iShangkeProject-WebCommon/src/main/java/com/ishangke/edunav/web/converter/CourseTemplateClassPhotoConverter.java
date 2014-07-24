package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseTemplateClassPhotoBo;
import com.ishangke.edunav.web.model.CourseTemplateClassPhotoVo;

public class CourseTemplateClassPhotoConverter {
    public static CourseTemplateClassPhotoBo fromModel(CourseTemplateClassPhotoVo vo) {
        CourseTemplateClassPhotoBo courseTemplateClassPhotoBo = new CourseTemplateClassPhotoBo();
        if (vo.getClassPhotoId() != null) {
            courseTemplateClassPhotoBo.setClassPhotoId(vo.getClassPhotoId());
        }
        if (vo.getClassPhotoIdSet() != null) {
            courseTemplateClassPhotoBo.setClassPhotoIdSet(vo.getClassPhotoIdSet());
        }
        if (vo.getCourseTemplateId() != null) {
            courseTemplateClassPhotoBo.setCourseTemplateId(vo.getCourseTemplateId());
        }
        if (vo.getCourseTemplateIdSet() != null) {
            courseTemplateClassPhotoBo.setCourseTemplateIdSet(vo.getCourseTemplateIdSet());
        }
        if (vo.getId() != null) {
            courseTemplateClassPhotoBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            courseTemplateClassPhotoBo.setIdSet(vo.getIdSet());
        }
        courseTemplateClassPhotoBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        courseTemplateClassPhotoBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        courseTemplateClassPhotoBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        return courseTemplateClassPhotoBo;
    }

    public static CourseTemplateClassPhotoVo toModel(CourseTemplateClassPhotoBo bo) {
        CourseTemplateClassPhotoVo courseTemplateClassPhotoVo = new CourseTemplateClassPhotoVo();
        courseTemplateClassPhotoVo.setClassPhotoId(bo.getClassPhotoId());
        courseTemplateClassPhotoVo.setClassPhotoIdSet(bo.getClassPhotoIdSet());
        courseTemplateClassPhotoVo.setCourseTemplateId(bo.getCourseTemplateId());
        courseTemplateClassPhotoVo.setCourseTemplateIdSet(bo.getCourseTemplateIdSet());
        courseTemplateClassPhotoVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        courseTemplateClassPhotoVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        courseTemplateClassPhotoVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        courseTemplateClassPhotoVo.setId(bo.getId());
        courseTemplateClassPhotoVo.setIdSet(bo.getIdSet());
        return courseTemplateClassPhotoVo;
    }
}
