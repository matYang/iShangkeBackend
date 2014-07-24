package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ContactBo;
import com.ishangke.edunav.dataaccess.model.ContactEntityExt;

public class ContactConverter {
    public static ContactBo toBo(ContactEntityExt e) {
        ContactBo contactBo = new ContactBo();
        contactBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        contactBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        contactBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        contactBo.setEmail(e.getEmail());
        contactBo.setEnabled(e.getEnabled());
        contactBo.setId(e.getId());
        contactBo.setIdSet(e.getIdSet());
        contactBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        contactBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        contactBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        contactBo.setName(e.getName());
        contactBo.setPhone(e.getPhone());
        contactBo.setUserId(e.getUserId());
        contactBo.setUserIdSet(e.getUserIdSet());
        return contactBo;
    }

    public static ContactEntityExt fromBo(ContactBo bo) {
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
