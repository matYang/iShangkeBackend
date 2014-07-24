package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.web.model.ClassPhotoVo;

public class ClassPhotoConverter {
    public static ClassPhotoBo fromModel(ClassPhotoVo vo) {
        ClassPhotoBo classPhotoBo = new ClassPhotoBo();
        if (vo.getDescription() != null) {
            classPhotoBo.setDescription(vo.getDescription());
        }
        if (vo.getEnabled() != null) {
            classPhotoBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            classPhotoBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            classPhotoBo.setIdSet(vo.getIdSet());
        }
        if (vo.getImgUrl() != null) {
            classPhotoBo.setImgUrl(vo.getImgUrl());
        }
        if (vo.getPartnerId() != null) {
            classPhotoBo.setPartnerId(vo.getPartnerId());
        }
        if (vo.getPartnerIdSet() != null) {
            classPhotoBo.setPartnerIdSet(vo.getPartnerIdSet());
        }
        if (vo.getTitle() != null) {
            classPhotoBo.setTitle(vo.getTitle());
        }
        if (vo.getSnapshotUrl() != null) {
            classPhotoBo.setSnapshotUrl(vo.getSnapshotUrl());
        }
        classPhotoBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        classPhotoBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        classPhotoBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        classPhotoBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        classPhotoBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        classPhotoBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
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
        classPhotoVo.setSnapshotUrl(bo.getSnapshotUrl());
        return classPhotoVo;
    }
}
