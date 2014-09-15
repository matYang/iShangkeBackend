package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.web.model.UserVo;

public class UserConverter {
    public static UserBo fromModel(UserVo vo) {
        if (vo == null) {
            return null;
        }
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
        } else {
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
        if (vo.getMajorId() != null) {
            userBo.setMajorId(vo.getMajorId());
        }
        if (vo.getMajorIdSet() != null) {
            userBo.setMajorIdSet(vo.getMajorIdSet());
        }
        if (vo.getBirthday() != null) {
            userBo.setBirthday(vo.getBirthday());
        } else {
            userBo.setBirthday(Constant.DEFAULTNULL);
        }
        if (vo.getBirthdayEnd() != null) {
            userBo.setBirthdayEnd(vo.getBirthdayEnd());
        } else {
            userBo.setBirthdayEnd(Constant.DEFAULTNULL);
        }
        if (vo.getBirthdayStart() != null) {
            userBo.setBirthdayStart(vo.getBirthdayStart());
        } else {
            userBo.setBirthdayStart(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTime() != null) {
            userBo.setCreateTime(vo.getCreateTime());
        } else {
            userBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            userBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            userBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            userBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            userBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastLoginTime() != null) {
            userBo.setLastLoginTime(vo.getLastLoginTime());
        } else {
            userBo.setLastLoginTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastLoginTimeEnd() != null) {
            userBo.setLastLoginTimeEnd(vo.getLastLoginTimeEnd());
        } else {
            userBo.setLastLoginTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastLoginTimeStart() != null) {
            userBo.setLastLoginTimeStart(vo.getLastLoginTimeStart());
        } else {
            userBo.setLastLoginTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            userBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            userBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            userBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            userBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            userBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            userBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLocationId() != null) {
            userBo.setLocationId(vo.getLocationId());
        }
        if (vo.getSchoolIdSet() != null) {
            userBo.setLocationIdSet(vo.getLocationIdSet());
        }
        return userBo;
    }

    public static UserVo toModel(UserBo bo) {
        if (bo == null) {
            return null;
        }
        // password不会出现到vo中
        UserVo userVo = new UserVo();
        userVo.setAppliedInvitationCode(bo.getAppliedInvitationCode());
        userVo.setAvatarUrl(bo.getAvatarUrl());
        userVo.setBirthday(bo.getBirthday());
        // userVo.setBirthdayEnd(bo.getBirthdayEnd());
        // userVo.setBirthdayStart(bo.getBirthdayStart());
        userVo.setCreateTime(bo.getCreateTime());
        // userVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        // userVo.setCreateTimeStart(bo.getCreateTimeStart());
        userVo.setEmail(bo.getEmail());
        userVo.setEnabled(bo.getEnabled());
        if (Constant.DEFAULTNULL != bo.getGender()) {
            userVo.setGender(bo.getGender());
        }
        userVo.setId(bo.getId());
        // userVo.setIdSet(bo.getIdSet());
        userVo.setInvitationCode(bo.getInvitationCode());
        userVo.setLastLoginTime(bo.getLastLoginTime());
        // userVo.setLastLoginTimeEnd(bo.getLastLoginTimeEnd());
        // userVo.setLastLoginTimeStart(bo.getLastLoginTimeStart());
        userVo.setLastModifyTime(bo.getLastModifyTime());
        // userVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
        // userVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        userVo.setMajor(bo.getMajor());
        userVo.setName(bo.getName());
        userVo.setPhone(bo.getPhone());
        userVo.setReference(bo.getReference());
        userVo.setSchool(bo.getSchool());
        userVo.setWechat(bo.getWechat());
        userVo.setCareerId(bo.getCareerId());
        // userVo.setCareerIdSet(bo.getCareerIdSet());
        userVo.setSchoolId(bo.getSchoolId());
        // userVo.setSchoolIdSet(bo.getSchoolIdSet());
        userVo.setMajorId(bo.getMajorId());
        // userVo.setMajorIdSet(bo.getMajorIdSet());
        userVo.setLocationId(bo.getLocationId());
        // userVo.setLocationIdSet(bo.getLocationIdSet());
        if (Constant.DEFAULTNULL != bo.getCouponTotal()) {
            userVo.setCouponTotal(bo.getCouponTotal());
        } else {
            // 不能显示null给用户看
            userVo.setCouponTotal(0.0);
        }
        userVo.setAccount(AccountConverter.toModel(bo.getAccount()));
        userVo.setCredit(CreditConverter.toModel(bo.getCredit()));
        userVo.setSchoolName(bo.getSchoolName());
        return userVo;
    }

    public static void main(String[] args) {
        String p = "8618013955974";
        char[] x = p.toCharArray();
        int l = x.length;
        String result = "";
        for (int i = 0; i < l; i++) {
            if (i < l - 4 && i > l - 9) {
                result = result + "*";
            } else {
                result = result + x[i];
            }
        }
        System.out.println(result);

    }
}
