package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.common.DateUtility;

public class UserConverter {
    public static UserBo fromModel(UserVo vo) {
        UserBo userBo = new UserBo();
        userBo.setAppliedInvitationCode(vo.getAppliedInvitationCode());
        userBo.setAvatarUrl(vo.getAvatarUrl());
        userBo.setBirthday(vo.getBirthday().getTimeInMillis());
        userBo.setBirthdayEnd(vo.getBirthdayEnd().getTimeInMillis());
        userBo.setBirthdayStart(vo.getBirthdayStart().getTimeInMillis());
        userBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        userBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        userBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        userBo.setEmail(vo.getEmail());
        userBo.setEnabled(vo.getEnabled());
        userBo.setGender(vo.getGender());
        userBo.setId(vo.getId());
        userBo.setIdSet(vo.getIdSet());
        userBo.setInvitationCode(vo.getInvitationCode());
        userBo.setLastLoginTime(vo.getLastLoginTime().getTimeInMillis());
        userBo.setLastLoginTimeEnd(vo.getLastLoginTimeEnd().getTimeInMillis());
        userBo.setLastLoginTimeStart(vo.getLastLoginTimeStart().getTimeInMillis());
        userBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        userBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        userBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
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
