package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseClassPhotoBo;
import com.ishangke.edunav.dataaccess.model.CourseClassPhotoEntityExt;

public class CourseClassPhotoConverter {
    public static CourseClassPhotoBo toBo(CourseClassPhotoEntityExt e) {
        CourseClassPhotoBo courseClassPhotoBo = new CourseClassPhotoBo();
        if (e.getClassPhotoId() != null) {
            courseClassPhotoBo.setClassPhotoId(e.getClassPhotoId());
        }
        if (e.getClassPhotoIdSet() != null) {
            courseClassPhotoBo.setClassPhotoIdSet(e.getClassPhotoIdSet());
        }
        if (e.getCourseId() != null) {
            courseClassPhotoBo.setCourseId(e.getCourseId());
        }
        if (e.getCourseIdSet() != null) {
            courseClassPhotoBo.setCourseIdSet(e.getCourseIdSet());
        }
        if (e.getId() != null) {
            courseClassPhotoBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            courseClassPhotoBo.setIdSet(e.getIdSet());
        }
        courseClassPhotoBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        courseClassPhotoBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        courseClassPhotoBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        return courseClassPhotoBo;
    }

    public static CourseClassPhotoEntityExt fromBo(CourseClassPhotoBo bo) {
        CourseClassPhotoEntityExt courseClassPhotoEntityExt = new CourseClassPhotoEntityExt();
        courseClassPhotoEntityExt.setClassPhotoId(bo.getClassPhotoId());
        courseClassPhotoEntityExt.setClassPhotoIdSet(bo.getClassPhotoIdSet());
        courseClassPhotoEntityExt.setCourseId(bo.getCourseId());
        courseClassPhotoEntityExt.setCourseIdSet(bo.getCourseIdSet());
        courseClassPhotoEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        courseClassPhotoEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        courseClassPhotoEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        courseClassPhotoEntityExt.setId(bo.getId());
        courseClassPhotoEntityExt.setIdSet(bo.getIdSet());
        return courseClassPhotoEntityExt;
    }
}
