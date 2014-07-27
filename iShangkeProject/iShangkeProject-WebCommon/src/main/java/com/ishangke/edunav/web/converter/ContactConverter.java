package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
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
        contactBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime()
                .getTimeInMillis());
        contactBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd()
                .getTimeInMillis());
        contactBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart()
                .getTimeInMillis());
        contactBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime()
                .getTimeInMillis());
        contactBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeEnd().getTimeInMillis());
        contactBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeStart().getTimeInMillis());
        return contactBo;
    }

    public static ContactVo toModel(ContactBo bo) {
        if (bo == null) {
            return null;
        }
        ContactVo contactVo = new ContactVo();
        contactVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        contactVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        contactVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        contactVo.setEmail(bo.getEmail());
        contactVo.setEnabled(bo.getEnabled());
        contactVo.setId(bo.getId());
        contactVo.setIdSet(bo.getIdSet());
        contactVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        contactVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        contactVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        contactVo.setName(bo.getName());
        contactVo.setPhone(bo.getPhone());
        contactVo.setUserId(bo.getUserId());
        contactVo.setUserIdSet(bo.getUserIdSet());
        return contactVo;
    }
}
