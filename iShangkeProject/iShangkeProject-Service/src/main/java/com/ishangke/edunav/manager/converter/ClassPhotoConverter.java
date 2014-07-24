package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;

public class ClassPhotoConverter {
    public static ClassPhotoBo toBo(ClassPhotoEntityExt e) {
        ClassPhotoBo classPhotoBo = new ClassPhotoBo();
        classPhotoBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        classPhotoBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        classPhotoBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        classPhotoBo.setDescription(e.getDescription());
        classPhotoBo.setEnabled(e.getEnabled());
        classPhotoBo.setId(e.getId());
        classPhotoBo.setIdSet(e.getIdSet());
        classPhotoBo.setImgUrl(e.getImgUrl());
        classPhotoBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        classPhotoBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        classPhotoBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        classPhotoBo.setPartnerId(e.getPartnerId());
        classPhotoBo.setPartnerIdSet(e.getPartnerIdSet());
        classPhotoBo.setTitle(e.getTitle());
        return classPhotoBo;
    }

    public static ClassPhotoEntityExt fromBo(ClassPhotoBo bo) {
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
