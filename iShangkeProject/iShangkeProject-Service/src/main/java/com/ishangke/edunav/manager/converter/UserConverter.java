package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class UserConverter {
    public static UserBo toBo(UserEntityExt e) {
        UserBo userBo = new UserBo();
        userBo.setAppliedInvitationCode(e.getAppliedInvitationCode());
        userBo.setAvatarUrl(e.getAvatarUrl());
        userBo.setBirthday(e.getBirthday().getTimeInMillis());
        userBo.setBirthdayEnd(e.getBirthdayEnd().getTimeInMillis());
        userBo.setBirthdayStart(e.getBirthdayStart().getTimeInMillis());
        userBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        userBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        userBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        userBo.setEmail(e.getEmail());
        userBo.setEnabled(e.getEnabled());
        userBo.setGender(e.getGender());
        userBo.setId(e.getId());
        userBo.setIdSet(e.getIdSet());
        userBo.setInvitationCode(e.getInvitationCode());
        userBo.setLastLoginTime(e.getLastLoginTime().getTimeInMillis());
        userBo.setLastLoginTimeEnd(e.getLastLoginTimeEnd().getTimeInMillis());
        userBo.setLastLoginTimeStart(e.getLastLoginTimeStart().getTimeInMillis());
        userBo.setLastModifyTime(e.getLastModifyTime().getTimeInMillis());
        userBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd().getTimeInMillis());
        userBo.setLastModifyTimeStart(e.getLastModifyTimeStart().getTimeInMillis());
        userBo.setMajor(e.getMajor());
        userBo.setName(e.getName());
        userBo.setPassword(e.getPassword());
        userBo.setPhone(e.getPhone());
        userBo.setReference(e.getReference());
        userBo.setSchool(e.getSchool());
        userBo.setWechat(e.getWechat());
        return userBo;
    }

    public static UserEntityExt fromBo(UserBo bo) {
        UserEntityExt userEntityExt = new UserEntityExt();
        userEntityExt.setAppliedInvitationCode(bo.getAppliedInvitationCode());
        userEntityExt.setAvatarUrl(bo.getAvatarUrl());
        userEntityExt.setBirthday(DateUtility.getTimeFromLong(bo.getBirthday()));
        userEntityExt.setBirthdayEnd(DateUtility.getTimeFromLong(bo.getBirthdayEnd()));
        userEntityExt.setBirthdayStart(DateUtility.getTimeFromLong(bo.getBirthdayStart()));
        userEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        userEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        userEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        userEntityExt.setEmail(bo.getEmail());
        userEntityExt.setEnabled(bo.getEnabled());
        userEntityExt.setGender(bo.getGender());
        userEntityExt.setId(bo.getId());
        userEntityExt.setIdSet(bo.getIdSet());
        userEntityExt.setInvitationCode(bo.getInvitationCode());
        userEntityExt.setLastLoginTime(DateUtility.getTimeFromLong(bo.getLastLoginTime()));
        userEntityExt.setLastLoginTimeEnd(DateUtility.getTimeFromLong(bo.getLastLoginTimeEnd()));
        userEntityExt.setLastLoginTimeStart(DateUtility.getTimeFromLong(bo.getLastLoginTimeStart()));
        userEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        userEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        userEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        userEntityExt.setMajor(bo.getMajor());
        userEntityExt.setName(bo.getName());
        userEntityExt.setPassword(bo.getPassword());
        userEntityExt.setPhone(bo.getPhone());
        userEntityExt.setReference(bo.getReference());
        userEntityExt.setSchool(bo.getSchool());
        userEntityExt.setWechat(bo.getWechat());
        return userEntityExt;
    }
}
