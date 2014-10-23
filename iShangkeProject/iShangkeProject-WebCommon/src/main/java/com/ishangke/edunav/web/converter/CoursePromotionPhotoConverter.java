package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.CoursePromotionPhotoBo;
import com.ishangke.edunav.web.model.CoursePromotionPhotoVo;

public class CoursePromotionPhotoConverter {
    public static CoursePromotionPhotoBo fromModel(CoursePromotionPhotoVo vo) {
        if (vo == null) {
            return null;
        }
        CoursePromotionPhotoBo bo = new CoursePromotionPhotoBo();
        if (vo.getId() != null) {
            bo.setId(vo.getId());
        }
        if (vo.getCoursePromotionId() != null) {
            bo.setCoursePromotionId(vo.getCoursePromotionId());
        }
        if (vo.getUrl() != null) {
            bo.setUrl(vo.getUrl());
        }
        if (vo.getType() != null) {
            bo.setType(vo.getType());
        } else {
            bo.setType(Constant.DEFAULTNULL);
        }
        return bo;
    }
    
    public static CoursePromotionPhotoVo toModel(CoursePromotionPhotoBo bo) {
        if (bo == null) {
            return null;
        }
        CoursePromotionPhotoVo vo = new CoursePromotionPhotoVo();
        vo.setId(bo.getId());
        vo.setCoursePromotionId(bo.getCoursePromotionId());
        vo.setUrl(bo.getUrl());
        if (bo.getType() != Constant.DEFAULTNULL) {
            vo.setType(bo.getType());
        }
        return vo;
    }
}
