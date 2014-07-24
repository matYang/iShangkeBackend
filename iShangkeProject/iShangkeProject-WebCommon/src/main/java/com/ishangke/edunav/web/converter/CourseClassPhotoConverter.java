package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseClassPhotoBo;
import com.ishangke.edunav.web.model.CourseClassPhotoVo;

public class CourseClassPhotoConverter {
    public static CourseClassPhotoBo fromModel(CourseClassPhotoVo vo) {
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
        courseClassPhotoBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        courseClassPhotoBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        courseClassPhotoBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        return courseClassPhotoBo;
    }

    public static CourseClassPhotoVo toModel(CourseClassPhotoBo bo) {
        CourseClassPhotoVo courseClassPhotoVo = new CourseClassPhotoVo();
        courseClassPhotoVo.setClassPhotoId(bo.getClassPhotoId());
        courseClassPhotoVo.setClassPhotoIdSet(bo.getClassPhotoIdSet());
        courseClassPhotoVo.setCourseId(bo.getCourseId());
        courseClassPhotoVo.setCourseIdSet(bo.getCourseIdSet());
        courseClassPhotoVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        courseClassPhotoVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        courseClassPhotoVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        courseClassPhotoVo.setId(bo.getId());
        courseClassPhotoVo.setIdSet(bo.getIdSet());
        return courseClassPhotoVo;
    }
}
