package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.web.model.ClassPhotoVo;

public class ClassPhotoConverter {
    public static ClassPhotoBo fromModel(ClassPhotoVo vo) {
        if (vo == null) {
            return null;
        }
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
        if (vo.getCreateTime() != null) {
            classPhotoBo.setCreateTime(vo.getCreateTime());
        } else {
            classPhotoBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            classPhotoBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            classPhotoBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            classPhotoBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            classPhotoBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            classPhotoBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            classPhotoBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            classPhotoBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            classPhotoBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            classPhotoBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            classPhotoBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return classPhotoBo;
    }

    public static ClassPhotoVo toModel(ClassPhotoBo bo) {
        if (bo == null) {
            return null;
        }
        ClassPhotoVo classPhotoVo = new ClassPhotoVo();
        classPhotoVo.setCreateTime(bo.getCreateTime());
//        classPhotoVo.setCreateTimeEnd(bo.getCreateTimeEnd());
//        classPhotoVo.setCreateTimeStart(bo.getCreateTimeStart());
        classPhotoVo.setDescription(bo.getDescription());
        classPhotoVo.setEnabled(bo.getEnabled());
        classPhotoVo.setId(bo.getId());
//        classPhotoVo.setIdSet(bo.getIdSet());
        classPhotoVo.setImgUrl(bo.getImgUrl());
        classPhotoVo.setLastModifyTime(bo.getLastModifyTime());
//        classPhotoVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
//        classPhotoVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        classPhotoVo.setPartnerId(bo.getPartnerId());
//        classPhotoVo.setPartnerIdSet(bo.getPartnerIdSet());
        classPhotoVo.setTitle(bo.getTitle());
        classPhotoVo.setSnapshotUrl(bo.getSnapshotUrl());
        return classPhotoVo;
    }
}
