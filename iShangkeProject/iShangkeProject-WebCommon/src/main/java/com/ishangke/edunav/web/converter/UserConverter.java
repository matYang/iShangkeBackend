package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.web.model.UserVo;

public class UserConverter {
    public static UserBo fromModel(UserVo vo) {
        UserBo userBo = new UserBo();
        if (vo.getAppliedInvitationCode() != null) {
            userBo.setAppliedInvitationCode(vo.getAppliedInvitationCode());
        }
        if (vo.getAvatarUrl() != null) {
            userBo.setAvatarUrl(vo.getAvatarUrl());
        }
        if (vo.getEmail() != null) {
            userBo.setEmail(vo.getEmail());
        }
        if (vo.getEnabled() != null) {
            userBo.setEnabled(vo.getEnabled());
        }
        if (vo.getGender() != null) {
            userBo.setGender(vo.getGender());
        }  else {
            userBo.setGender(Constant.DEFAULTNULL);
        }
        if (vo.getId() != null) {
            userBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            userBo.setIdSet(vo.getIdSet());
        }
        if (vo.getInvitationCode() != null) {
            userBo.setInvitationCode(vo.getInvitationCode());
        }
        if (vo.getMajor() != null) {
            userBo.setMajor(vo.getMajor());
        }
        if (vo.getName() != null) {
            userBo.setName(vo.getName());
        }
        if (vo.getPassword() != null) {
            userBo.setPassword(vo.getPassword());
        }
        if (vo.getPhone() != null) {
            userBo.setPhone(vo.getPhone());
        }
        if (vo.getReference() != null) {
            userBo.setReference(vo.getReference());
        }
        if (vo.getSchool() != null) {
            userBo.setSchool(vo.getSchool());
        }
        if (vo.getWechat() != null) {
            userBo.setWechat(vo.getWechat());
        }
        if (vo.getCareerId() != null) {
            userBo.setCareerId(vo.getCareerId());
        }
        if (vo.getCareerIdSet() != null) {
            userBo.setCareerIdSet(vo.getCareerIdSet());
        }
        if (vo.getSchoolId() != null) {
            userBo.setSchoolId(vo.getSchoolId());
        }
        if (vo.getSchoolIdSet() != null) {
            userBo.setSchoolIdSet(vo.getSchoolIdSet());
        }
        userBo.setBirthday(vo.getBirthday() == null ? Constant.DEFAULTNULL : vo.getBirthday().getTimeInMillis());
        userBo.setBirthdayEnd(vo.getBirthdayEnd() == null ? Constant.DEFAULTNULL : vo.getBirthdayEnd().getTimeInMillis());
        userBo.setBirthdayStart(vo.getBirthdayStart() == null ? Constant.DEFAULTNULL : vo.getBirthdayStart().getTimeInMillis());
        userBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        userBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        userBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        userBo.setLastLoginTime(vo.getLastLoginTime() == null ? Constant.DEFAULTNULL : vo.getLastLoginTime().getTimeInMillis());
        userBo.setLastLoginTimeEnd(vo.getLastLoginTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastLoginTimeEnd().getTimeInMillis());
        userBo.setLastLoginTimeStart(vo.getLastLoginTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastLoginTimeStart().getTimeInMillis());
        userBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        userBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        userBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        return userBo;
    }

    public static UserVo toModel(UserBo bo) {
        UserVo userVo = new UserVo();
        userVo.setAppliedInvitationCode(bo.getAppliedInvitationCode());
        userVo.setAvatarUrl(bo.getAvatarUrl());
        userVo.setBirthday(DateUtility.getTimeFromLong(bo.getBirthday()));
        userVo.setBirthdayEnd(DateUtility.getTimeFromLong(bo.getBirthdayEnd()));
        userVo.setBirthdayStart(DateUtility.getTimeFromLong(bo.getBirthdayStart()));
        userVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        userVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        userVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        userVo.setEmail(bo.getEmail());
        userVo.setEnabled(bo.getEnabled());
        if (Constant.DEFAULTNULL != bo.getGender()) {
        userVo.setGender(bo.getGender());
        }
        userVo.setId(bo.getId());
        userVo.setIdSet(bo.getIdSet());
        userVo.setInvitationCode(bo.getInvitationCode());
        userVo.setLastLoginTime(DateUtility.getTimeFromLong(bo.getLastLoginTime()));
        userVo.setLastLoginTimeEnd(DateUtility.getTimeFromLong(bo.getLastLoginTimeEnd()));
        userVo.setLastLoginTimeStart(DateUtility.getTimeFromLong(bo.getLastLoginTimeStart()));
        userVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        userVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        userVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        userVo.setMajor(bo.getMajor());
        userVo.setName(bo.getName());
        userVo.setPassword(bo.getPassword());
        userVo.setPhone(bo.getPhone());
        userVo.setReference(bo.getReference());
        userVo.setSchool(bo.getSchool());
        userVo.setWechat(bo.getWechat());
        userVo.setCareerId(bo.getCareerId());
        userVo.setCareerIdSet(bo.getCareerIdSet());
        userVo.setSchoolId(bo.getSchoolId());
        userVo.setSchoolIdSet(bo.getSchoolIdSet());
        return userVo;
    }
}
