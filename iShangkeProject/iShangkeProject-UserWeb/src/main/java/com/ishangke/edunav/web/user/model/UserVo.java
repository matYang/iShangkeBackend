package com.ishangke.edunav.web.user.model;

import java.util.Calendar;
import java.util.Set;

public class UserVo {
    private Integer id;

    private String name;

    private String password;

    private String phone;

    private String wechat;

    private String email;

    private String avatarUrl;

    private String invitationCode;

    private String appliedInvitationCode;

    private String reference;

    private Calendar lastLoginTime;

    private Calendar lastModifyTime;

    private Calendar createTime;

    private Integer enabled;

    private Integer gender;

    private Calendar birthday;

    private String school;

    private String major;
    private Set<Integer> idSet;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    private Calendar lastLoginTimeStart;
    private Calendar lastLoginTimeEnd;
    private Calendar birthdayStart;
    private Calendar birthdayEnd;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getWechat() {
        return wechat;
    }
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAvatarUrl() {
        return avatarUrl;
    }
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    public String getInvitationCode() {
        return invitationCode;
    }
    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }
    public String getAppliedInvitationCode() {
        return appliedInvitationCode;
    }
    public void setAppliedInvitationCode(String appliedInvitationCode) {
        this.appliedInvitationCode = appliedInvitationCode;
    }
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public Calendar getLastLoginTime() {
        return lastLoginTime;
    }
    public void setLastLoginTime(Calendar lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    public Calendar getLastModifyTime() {
        return lastModifyTime;
    }
    public void setLastModifyTime(Calendar lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
    public Calendar getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Calendar createTime) {
        this.createTime = createTime;
    }
    public Integer getEnabled() {
        return enabled;
    }
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
    public Integer getGender() {
        return gender;
    }
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    public Calendar getBirthday() {
        return birthday;
    }
    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public Set<Integer> getIdSet() {
        return idSet;
    }
    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }
    public Calendar getLastModifyTimeStart() {
        return lastModifyTimeStart;
    }
    public void setLastModifyTimeStart(Calendar lastModifyTimeStart) {
        this.lastModifyTimeStart = lastModifyTimeStart;
    }
    public Calendar getLastModifyTimeEnd() {
        return lastModifyTimeEnd;
    }
    public void setLastModifyTimeEnd(Calendar lastModifyTimeEnd) {
        this.lastModifyTimeEnd = lastModifyTimeEnd;
    }
    public Calendar getCreateTimeStart() {
        return createTimeStart;
    }
    public void setCreateTimeStart(Calendar createTimeStart) {
        this.createTimeStart = createTimeStart;
    }
    public Calendar getCreateTimeEnd() {
        return createTimeEnd;
    }
    public void setCreateTimeEnd(Calendar createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
    public Calendar getLastLoginTimeStart() {
        return lastLoginTimeStart;
    }
    public void setLastLoginTimeStart(Calendar lastLoginTimeStart) {
        this.lastLoginTimeStart = lastLoginTimeStart;
    }
    public Calendar getLastLoginTimeEnd() {
        return lastLoginTimeEnd;
    }
    public void setLastLoginTimeEnd(Calendar lastLoginTimeEnd) {
        this.lastLoginTimeEnd = lastLoginTimeEnd;
    }
    public Calendar getBirthdayStart() {
        return birthdayStart;
    }
    public void setBirthdayStart(Calendar birthdayStart) {
        this.birthdayStart = birthdayStart;
    }
    public Calendar getBirthdayEnd() {
        return birthdayEnd;
    }
    public void setBirthdayEnd(Calendar birthdayEnd) {
        this.birthdayEnd = birthdayEnd;
    }
    
}
