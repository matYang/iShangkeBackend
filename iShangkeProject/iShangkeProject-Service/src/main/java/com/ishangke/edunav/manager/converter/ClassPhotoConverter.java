package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;

public class ClassPhotoConverter {
    public static ClassPhotoBo toBo(ClassPhotoEntityExt e) {
        if (e == null) {
            return null;
        }
        ClassPhotoBo classPhotoBo = new ClassPhotoBo();
        if (e.getDescription() != null) {
            classPhotoBo.setDescription(e.getDescription());
        }
        if (e.getEnabled() != null) {
            classPhotoBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            classPhotoBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            classPhotoBo.setIdSet(e.getIdSet());
        }
        if (e.getImgUrl() != null) {
            classPhotoBo.setImgUrl(e.getImgUrl());
        }
        if (e.getPartnerId() != null) {
            classPhotoBo.setPartnerId(e.getPartnerId());
        }
        if (e.getPartnerIdSet() != null) {
            classPhotoBo.setPartnerIdSet(e.getPartnerIdSet());
        }
        if (e.getTitle() != null) {
            classPhotoBo.setTitle(e.getTitle());
        }
        classPhotoBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime()
                .getTimeInMillis());
        classPhotoBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        classPhotoBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart()
                .getTimeInMillis());
        classPhotoBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        classPhotoBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeEnd().getTimeInMillis());
        classPhotoBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        return classPhotoBo;
    }

    public static ClassPhotoEntityExt fromBo(ClassPhotoBo bo) {
        if (bo == null) {
            return null;
        }
        ClassPhotoEntityExt classPhotoEntityExt = new ClassPhotoEntityExt();
        classPhotoEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        classPhotoEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        classPhotoEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        classPhotoEntityExt.setDescription(bo.getDescription());
        classPhotoEntityExt.setEnabled(bo.getEnabled());
        classPhotoEntityExt.setId(bo.getId());
        classPhotoEntityExt.setIdSet(bo.getIdSet());
        classPhotoEntityExt.setImgUrl(bo.getImgUrl());
        classPhotoEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        classPhotoEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        classPhotoEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        classPhotoEntityExt.setPartnerId(bo.getPartnerId());
        classPhotoEntityExt.setPartnerIdSet(bo.getPartnerIdSet());
        classPhotoEntityExt.setTitle(bo.getTitle());
        return classPhotoEntityExt;
    }
}
