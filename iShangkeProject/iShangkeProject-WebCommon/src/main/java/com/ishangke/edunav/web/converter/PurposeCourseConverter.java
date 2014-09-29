package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.PurposeCourseBo;
import com.ishangke.edunav.web.model.PurposeCourseVo;

public class PurposeCourseConverter {
    public static PurposeCourseBo fromModel(PurposeCourseVo vo) {
        if (vo == null) {
            return null;
        }
        PurposeCourseBo bo = new PurposeCourseBo();
        if (vo.getCategoryId() != null) {
            bo.setCategoryId(vo.getCategoryId());
        } else {
            bo.setCategoryId(Constant.DEFAULTNULL);
        }
        if (vo.getId() != null) {
            bo.setId(vo.getId());
        }
        if (vo.getPhone() != null) {
            bo.setPhone(vo.getPhone());
        }
        if (vo.getRemark() != null) {
            bo.setRemark(vo.getRemark());
        }
        if (vo.getUserName() != null) {
            bo.setUserName(vo.getUserName());
        }
        if (vo.getCreateTime() != null) {
            bo.setCreateTime(vo.getCreateTime());
        } else {
            bo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            bo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            bo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            bo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            bo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        return bo;
    }

    public static PurposeCourseVo toModel(PurposeCourseBo bo) {
        if (bo == null) {
            return null;
        }
        PurposeCourseVo vo = new PurposeCourseVo();
        if (bo.getCategoryId() != Constant.DEFAULTNULL) {
            vo.setCategoryId(bo.getCategoryId());            
        }
        vo.setId(bo.getId());
        vo.setPhone(bo.getPhone());
        vo.setRemark(bo.getRemark());
        vo.setUserName(bo.getUserName());
        if (Constant.DEFAULTNULL != bo.getCreateTime()) {
            vo.setCreateTime(bo.getCreateTime());
        }
        return vo;
    }
}
