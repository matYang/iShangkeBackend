package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.CourseClassPhotoBo;
import com.ishangke.edunav.web.model.CourseClassPhotoVo;

public class CourseClassPhotoConverter {
    public static CourseClassPhotoBo fromModel(CourseClassPhotoVo vo) {
        if (vo == null) {
            return null;
        }
        CourseClassPhotoBo courseClassPhotoBo = new CourseClassPhotoBo();
        if (vo.getClassPhotoId() != null) {
            courseClassPhotoBo.setClassPhotoId(vo.getClassPhotoId());
        }
        if (vo.getClassPhotoIdSet() != null) {
            courseClassPhotoBo.setClassPhotoIdSet(vo.getClassPhotoIdSet());
        }
        if (vo.getCourseId() != null) {
            courseClassPhotoBo.setCourseId(vo.getCourseId());
        }
        if (vo.getCourseIdSet() != null) {
            courseClassPhotoBo.setCourseIdSet(vo.getCourseIdSet());
        }
        if (vo.getId() != null) {
            courseClassPhotoBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            courseClassPhotoBo.setIdSet(vo.getIdSet());
        }
        if (vo.getCreateTime() != null) {
            courseClassPhotoBo.setCreateTime(vo.getCreateTime());
        } else {
            courseClassPhotoBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            courseClassPhotoBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            courseClassPhotoBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            courseClassPhotoBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            courseClassPhotoBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        return courseClassPhotoBo;
    }

    public static CourseClassPhotoVo toModel(CourseClassPhotoBo bo) {
        if (bo == null) {
            return null;
        }
        CourseClassPhotoVo courseClassPhotoVo = new CourseClassPhotoVo();
        courseClassPhotoVo.setClassPhotoId(bo.getClassPhotoId());
//        courseClassPhotoVo.setClassPhotoIdSet(bo.getClassPhotoIdSet());
        courseClassPhotoVo.setCourseId(bo.getCourseId());
//        courseClassPhotoVo.setCourseIdSet(bo.getCourseIdSet());
        courseClassPhotoVo.setCreateTime(bo.getCreateTime());
//        courseClassPhotoVo.setCreateTimeEnd(bo.getCreateTimeEnd());
//        courseClassPhotoVo.setCreateTimeStart(bo.getCreateTimeStart());
        courseClassPhotoVo.setId(bo.getId());
//        courseClassPhotoVo.setIdSet(bo.getIdSet());
        return courseClassPhotoVo;
    }
}
