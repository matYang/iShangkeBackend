package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.ContactBo;
import com.ishangke.edunav.web.model.ContactVo;

public class ContactConverter {
    public static ContactBo fromModel(ContactVo vo) {
        if (vo == null) {
            return null;
        }
        ContactBo contactBo = new ContactBo();
        if (vo.getEmail() != null) {
            contactBo.setEmail(vo.getEmail());
        }
        if (vo.getEnabled() != null) {
            contactBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            contactBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            contactBo.setIdSet(vo.getIdSet());
        }
        if (vo.getName() != null) {
            contactBo.setName(vo.getName());
        }
        if (vo.getPhone() != null) {
            contactBo.setPhone(vo.getPhone());
        }
        if (vo.getUserId() != null) {
            contactBo.setUserId(vo.getUserId());
        }
        if (vo.getUserIdSet() != null) {
            contactBo.setUserIdSet(vo.getUserIdSet());
        }
        if (vo.getCreateTime() != null) {
            contactBo.setCreateTime(vo.getCreateTime());
        } else {
            contactBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            contactBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            contactBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            contactBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            contactBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            contactBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            contactBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            contactBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            contactBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            contactBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            contactBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return contactBo;
    }

    public static ContactVo toModel(ContactBo bo) {
        if (bo == null) {
            return null;
        }
        ContactVo contactVo = new ContactVo();
        contactVo.setCreateTime(bo.getCreateTime());
        contactVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        contactVo.setCreateTimeStart(bo.getCreateTimeStart());
        contactVo.setEmail(bo.getEmail());
        contactVo.setEnabled(bo.getEnabled());
        contactVo.setId(bo.getId());
        contactVo.setIdSet(bo.getIdSet());
        contactVo.setLastModifyTime(bo.getLastModifyTime());
        contactVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
        contactVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        contactVo.setName(bo.getName());
        contactVo.setPhone(bo.getPhone());
        contactVo.setUserId(bo.getUserId());
        contactVo.setUserIdSet(bo.getUserIdSet());
        return contactVo;
    }
}
