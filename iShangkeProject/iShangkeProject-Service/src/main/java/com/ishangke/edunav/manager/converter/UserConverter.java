package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;

public class UserConverter {
    public static UserBo toBo(UserEntityExt e) {
        if (e == null) {
            return null;
        }
        UserBo userBo = new UserBo();
        if (e.getAppliedInvitationCode() != null) {
            userBo.setAppliedInvitationCode(e.getAppliedInvitationCode());
        }
        if (e.getAvatarUrl() != null) {
            userBo.setAvatarUrl(e.getAvatarUrl());
        }
        if (e.getEmail() != null) {
            userBo.setEmail(e.getEmail());
        }
        if (e.getEnabled() != null) {
            userBo.setEnabled(e.getEnabled());
        }
        if (e.getGender() != null) {
            userBo.setGender(e.getGender());
        } else {
            userBo.setGender(Constant.DEFAULTNULL);
        }
        if (e.getId() != null) {
            userBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            userBo.setIdSet(e.getIdSet());
        }
        if (e.getInvitationCode() != null) {
            userBo.setInvitationCode(e.getInvitationCode());
        }
        if (e.getMajor() != null) {
            userBo.setMajor(e.getMajor());
        }
        if (e.getName() != null) {
            userBo.setName(e.getName());
        }
        if (e.getPassword() != null) {
            userBo.setPassword(e.getPassword());
        }
        if (e.getPhone() != null) {
            userBo.setPhone(e.getPhone());
        }
        if (e.getReference() != null) {
            userBo.setReference(e.getReference());
        }
        if (e.getSchool() != null) {
            userBo.setSchool(e.getSchool());
        }
        if (e.getWechat() != null) {
            userBo.setWechat(e.getWechat());
        }
        if (e.getCareerId() != null) {
            userBo.setCareerId(e.getCareerId());
        }
        if (e.getCareerIdSet() != null) {
            userBo.setCareerIdSet(e.getCareerIdSet());
        }
        if (e.getSchoolId() != null) {
            userBo.setSchoolId(e.getSchoolId());
        }
        if (e.getMajorId() != null) {
            userBo.setMajorId(e.getMajorId());
        }
        if (e.getSchoolIdSet() != null) {
            userBo.setSchoolIdSet(e.getSchoolIdSet());
        }
        if (e.getMajorIdSet() != null) {
            userBo.setMajorIdSet(e.getMajorIdSet());
        }
        userBo.setBirthday(e.getBirthday() == null ? Constant.DEFAULTNULL : e.getBirthday().getTimeInMillis());
        userBo.setBirthdayEnd(e.getBirthdayEnd() == null ? Constant.DEFAULTNULL : e.getBirthdayEnd().getTimeInMillis());
        userBo.setBirthdayStart(e.getBirthdayStart() == null ? Constant.DEFAULTNULL : e.getBirthdayStart()
                .getTimeInMillis());
        userBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        userBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        userBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart()
                .getTimeInMillis());
        userBo.setLastLoginTime(e.getLastLoginTime() == null ? Constant.DEFAULTNULL : e.getLastLoginTime()
                .getTimeInMillis());
        userBo.setLastLoginTimeEnd(e.getLastLoginTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastLoginTimeEnd()
                .getTimeInMillis());
        userBo.setLastLoginTimeStart(e.getLastLoginTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastLoginTimeStart().getTimeInMillis());
        userBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        userBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd()
                .getTimeInMillis());
        userBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        if (e.getLocationId() != null) {
            userBo.setLocationId(e.getLocationId());
        }
        if (e.getLocationIdSet() != null) {
            userBo.setLocationIdSet(e.getLocationIdSet());
        }
        if (e.getCouponTotal() != null) {
            userBo.setCouponTotal(e.getCouponTotal());
        } else {
            userBo.setCouponTotal(Constant.DEFAULTNULL);
        }
        if (e.getAccount() != null) {
            userBo.setAccount(AccountConverter.toBo(e.getAccount()));
        }
        if (e.getCredit() != null) {
            userBo.setCredit(CreditConverter.toBo(e.getCredit()));
        }
        return userBo;
    }

    public static UserEntityExt fromBo(UserBo bo) {
        if (bo == null) {
            return null;
        }
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
        if (bo.getGender() != Constant.DEFAULTNULL) {
            userEntityExt.setGender(bo.getGender());
        }
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
        userEntityExt.setCareerId(bo.getCareerId());
        userEntityExt.setCareerIdSet(bo.getCareerIdSet());
        userEntityExt.setMajorId(bo.getMajorId());
        userEntityExt.setMajorIdSet(bo.getMajorIdSet());
        userEntityExt.setSchoolId(bo.getSchoolId());
        userEntityExt.setSchoolIdSet(bo.getSchoolIdSet());
        userEntityExt.setLocationId(bo.getLocationId());
        userEntityExt.setLocationIdSet(bo.getLocationIdSet());
        return userEntityExt;
    }
}
