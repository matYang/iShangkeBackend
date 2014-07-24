package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseClassPhotoBo;
import com.ishangke.edunav.web.model.CourseClassPhotoVo;

public class CourseClassPhotoConverter {
    public static CourseClassPhotoBo fromModel(CourseClassPhotoVo vo) {
        CourseClassPhotoBo courseClassPhotoBo = new CourseClassPhotoBo();
        courseClassPhotoBo.setClassPhotoId(vo.getClassPhotoId());
        courseClassPhotoBo.setClassPhotoIdSet(vo.getClassPhotoIdSet());
        courseClassPhotoBo.setCourseId(vo.getCourseId());
        courseClassPhotoBo.setCourseIdSet(vo.getCourseIdSet());
        courseClassPhotoBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        courseClassPhotoBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        courseClassPhotoBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        courseClassPhotoBo.setId(vo.getId());
        courseClassPhotoBo.setIdSet(vo.getIdSet());
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
