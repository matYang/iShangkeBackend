package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ContactBo;
import com.ishangke.edunav.dataaccess.model.ContactEntityExt;

public class ContactConverter {
    public static ContactBo toBo(ContactEntityExt e) {
        if (e == null) {
            return null;
        }
        ContactBo contactBo = new ContactBo();
        if (e.getEmail() != null) {
            contactBo.setEmail(e.getEmail());
        }
        if (e.getEnabled() != null) {
            contactBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            contactBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            contactBo.setIdSet(e.getIdSet());
        }
        if (e.getName() != null) {
            contactBo.setName(e.getName());
        }
        if (e.getPhone() != null) {
            contactBo.setPhone(e.getPhone());
        }
        if (e.getUserId() != null) {
            contactBo.setUserId(e.getUserId());
        }
        if (e.getUserIdSet() != null) {
            contactBo.setUserIdSet(e.getUserIdSet());
        }
        contactBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        contactBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        contactBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart()
                .getTimeInMillis());
        contactBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        contactBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeEnd().getTimeInMillis());
        contactBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        return contactBo;
    }

    public static ContactEntityExt fromBo(ContactBo bo) {
        if (bo == null) {
            return null;
        }
        ContactEntityExt contactEntityExt = new ContactEntityExt();
        contactEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        contactEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        contactEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        contactEntityExt.setEmail(bo.getEmail());
        contactEntityExt.setEnabled(bo.getEnabled());
        contactEntityExt.setId(bo.getId());
        contactEntityExt.setIdSet(bo.getIdSet());
        contactEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        contactEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        contactEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        contactEntityExt.setName(bo.getName());
        contactEntityExt.setPhone(bo.getPhone());
        contactEntityExt.setUserId(bo.getUserId());
        contactEntityExt.setUserIdSet(bo.getUserIdSet());
        return contactEntityExt;
    }
}
