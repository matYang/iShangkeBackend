package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.web.model.UserVo;

public class UserConverter {
    public static UserBo fromModel(UserVo vo) {
        UserBo userBo = new UserBo();
        userBo.setAppliedInvitationCode(vo.getAppliedInvitationCode());
        userBo.setAvatarUrl(vo.getAvatarUrl());
        userBo.setBirthday(vo.getBirthday() == null ? Constant.DEFAULTNULL : vo.getBirthday().getTimeInMillis());
        userBo.setBirthdayEnd(vo.getBirthdayEnd() == null ? Constant.DEFAULTNULL : vo.getBirthdayEnd().getTimeInMillis());
        userBo.setBirthdayStart(vo.getBirthdayStart() == null ? Constant.DEFAULTNULL : vo.getBirthdayStart().getTimeInMillis());
        userBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        userBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        userBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        userBo.setEmail(vo.getEmail());
        userBo.setEnabled(vo.getEnabled());
        userBo.setGender(vo.getGender());
        userBo.setId(vo.getId());
        userBo.setIdSet(vo.getIdSet());
        userBo.setInvitationCode(vo.getInvitationCode());
        userBo.setLastLoginTime(vo.getLastLoginTime() == null ? Constant.DEFAULTNULL : vo.getLastLoginTime().getTimeInMillis());
        userBo.setLastLoginTimeEnd(vo.getLastLoginTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastLoginTimeEnd().getTimeInMillis());
        userBo.setLastLoginTimeStart(vo.getLastLoginTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastLoginTimeStart().getTimeInMillis());
        userBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        userBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        userBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        userBo.setMajor(vo.getMajor());
        userBo.setName(vo.getName());
        userBo.setPassword(vo.getPassword());
        userBo.setPhone(vo.getPhone());
        userBo.setReference(vo.getReference());
        userBo.setSchool(vo.getSchool());
        userBo.setWechat(vo.getWechat());
        userBo.setCareerId(vo.getCareerId());
        userBo.setCareerIdSet(vo.getCareerIdSet());
        userBo.setSchoolId(vo.getSchoolId());
        userBo.setSchoolIdSet(vo.getSchoolIdSet());
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
        userVo.setGender(bo.getGender());
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
