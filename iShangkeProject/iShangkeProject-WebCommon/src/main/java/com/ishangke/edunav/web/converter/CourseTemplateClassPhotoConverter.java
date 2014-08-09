package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.CourseTemplateClassPhotoBo;
import com.ishangke.edunav.web.model.CourseTemplateClassPhotoVo;

public class CourseTemplateClassPhotoConverter {
    public static CourseTemplateClassPhotoBo fromModel(CourseTemplateClassPhotoVo vo) {
        if (vo == null) {
            return null;
        }
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
        if (vo.getCreateTime() != null) {
            courseTemplateClassPhotoBo.setCreateTime(vo.getCreateTime());
        } else {
            courseTemplateClassPhotoBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            courseTemplateClassPhotoBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            courseTemplateClassPhotoBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            courseTemplateClassPhotoBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            courseTemplateClassPhotoBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        return courseTemplateClassPhotoBo;
    }

    public static CourseTemplateClassPhotoVo toModel(CourseTemplateClassPhotoBo bo) {
        if (bo == null) {
            return null;
        }
        CourseTemplateClassPhotoVo courseTemplateClassPhotoVo = new CourseTemplateClassPhotoVo();
        courseTemplateClassPhotoVo.setClassPhotoId(bo.getClassPhotoId());
        courseTemplateClassPhotoVo.setClassPhotoIdSet(bo.getClassPhotoIdSet());
        courseTemplateClassPhotoVo.setCourseTemplateId(bo.getCourseTemplateId());
        courseTemplateClassPhotoVo.setCourseTemplateIdSet(bo.getCourseTemplateIdSet());
        courseTemplateClassPhotoVo.setCreateTime(bo.getCreateTime());
        courseTemplateClassPhotoVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        courseTemplateClassPhotoVo.setCreateTimeStart(bo.getCreateTimeStart());
        courseTemplateClassPhotoVo.setId(bo.getId());
        courseTemplateClassPhotoVo.setIdSet(bo.getIdSet());
        return courseTemplateClassPhotoVo;
    }
}
