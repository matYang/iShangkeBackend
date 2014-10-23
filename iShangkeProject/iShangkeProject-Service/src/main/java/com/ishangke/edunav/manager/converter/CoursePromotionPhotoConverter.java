package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.CoursePromotionPhotoBo;
import com.ishangke.edunav.dataaccess.model.CoursePromotionPhotoEntityExt;

public class CoursePromotionPhotoConverter {
    public static CoursePromotionPhotoBo toBo(CoursePromotionPhotoEntityExt e) {
        if (e == null) {
            return null;
        }
        CoursePromotionPhotoBo bo = new CoursePromotionPhotoBo();
        if( e.getId() != null) {
            bo.setId(e.getId());
        }
        if (e.getCoursePromotionId() != null) {
            bo.setCoursePromotionId(e.getCoursePromotionId());
        }
        if (e.getUrl() != null) {
            bo.setUrl(e.getUrl());
        }
        if (e.getType() != null) {
            bo.setType(e.getType());
        } else {
            bo.setType(Constant.DEFAULTNULL);
        }
        return bo;
    }
    
    public static CoursePromotionPhotoEntityExt fromBo(CoursePromotionPhotoBo bo) {
        if (bo == null) {
            return null;
        }
        CoursePromotionPhotoEntityExt e = new CoursePromotionPhotoEntityExt();
        e.setId(bo.getId());
        e.setCoursePromotionId(bo.getCoursePromotionId());
        e.setUrl(bo.getUrl());
        if (bo.getType() != Constant.DEFAULTNULL) {
            e.setType(bo.getType());
        }
        return e;
    }
}
