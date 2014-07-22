package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.web.model.ClassPhotoVo;
import com.ishangke.edunav.web.common.DateUtility;

public class ClassPhotoConverter {
    public static ClassPhotoBo fromModel(ClassPhotoVo vo) {
        ClassPhotoBo classPhotoBo = new ClassPhotoBo();
        classPhotoBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        classPhotoBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        classPhotoBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        classPhotoBo.setDescription(vo.getDescription());
        classPhotoBo.setEnabled(vo.getEnabled());
        classPhotoBo.setId(vo.getId());
        classPhotoBo.setIdSet(vo.getIdSet());
        classPhotoBo.setImgUrl(vo.getImgUrl());
        classPhotoBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        classPhotoBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        classPhotoBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
        classPhotoBo.setPartnerId(vo.getPartnerId());
        classPhotoBo.setPartnerIdSet(vo.getPartnerIdSet());
        classPhotoBo.setTitle(vo.getTitle());
        return classPhotoBo;
    }

    public static ClassPhotoVo toModel(ClassPhotoBo bo) {
        ClassPhotoVo classPhotoVo = new ClassPhotoVo();
        classPhotoVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        classPhotoVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        classPhotoVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        classPhotoVo.setDescription(bo.getDescription());
        classPhotoVo.setEnabled(bo.getEnabled());
        classPhotoVo.setId(bo.getId());
        classPhotoVo.setIdSet(bo.getIdSet());
        classPhotoVo.setImgUrl(bo.getImgUrl());
        classPhotoVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        classPhotoVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        classPhotoVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        classPhotoVo.setPartnerId(bo.getPartnerId());
        classPhotoVo.setPartnerIdSet(bo.getPartnerIdSet());
        classPhotoVo.setTitle(bo.getTitle());
        return classPhotoVo;
    }
}
