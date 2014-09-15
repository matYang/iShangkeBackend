package com.ishangke.edunav.web.model;

import java.util.Set;

import com.ishangke.edunav.web.response.JsonResponse;

public class UserVo extends JsonResponse {
    private Integer id;

    private String name;

    private String password;
    
    private String confirmPassword;

    private String phone;

    private String wechat;

    private String email;

    private String avatarUrl;

    private String invitationCode;

    private String appliedInvitationCode;

    private String reference;

    private Long lastLoginTime;

    private Long lastModifyTime;

    private Long createTime;

    private Integer enabled;

    private Integer gender;

    private Long birthday;

    private String school;

    private String major;
    private Set<Integer> idSet;
    private Long lastModifyTimeStart;
    private Long lastModifyTimeEnd;
    private Long createTimeStart;
    private Long createTimeEnd;
    private Long lastLoginTimeStart;
    private Long lastLoginTimeEnd;
    private Long birthdayStart;
    private Long birthdayEnd;
    private Integer careerId;
    private Integer schoolId;
    private Integer majorId;
    private Set<Integer> careerIdSet;
    private Set<Integer> schoolIdSet;
    private Set<Integer> majorIdSet;
    private Integer locationId;
    private Set<Integer> locationIdSet;
    
    private String authCode;
    
    private AccountVo account;
    private CreditVo credit;
    
    private Double couponTotal;
    
    private Integer partnerId;

    private Integer roleId;
    
    private String schoolName;
    
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Set<Integer> getMajorIdSet() {
        return majorIdSet;
    }

    public void setMajorIdSet(Set<Integer> majorIdSet) {
        this.majorIdSet = majorIdSet;
    }

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

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
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

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
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

    public Long getLastModifyTimeStart() {
        return lastModifyTimeStart;
    }

    public void setLastModifyTimeStart(Long lastModifyTimeStart) {
        this.lastModifyTimeStart = lastModifyTimeStart;
    }

    public Long getLastModifyTimeEnd() {
        return lastModifyTimeEnd;
    }

    public void setLastModifyTimeEnd(Long lastModifyTimeEnd) {
        this.lastModifyTimeEnd = lastModifyTimeEnd;
    }

    public Long getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Long createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Long getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Long createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public Long getLastLoginTimeStart() {
        return lastLoginTimeStart;
    }

    public void setLastLoginTimeStart(Long lastLoginTimeStart) {
        this.lastLoginTimeStart = lastLoginTimeStart;
    }

    public Long getLastLoginTimeEnd() {
        return lastLoginTimeEnd;
    }

    public void setLastLoginTimeEnd(Long lastLoginTimeEnd) {
        this.lastLoginTimeEnd = lastLoginTimeEnd;
    }

    public Long getBirthdayStart() {
        return birthdayStart;
    }

    public void setBirthdayStart(Long birthdayStart) {
        this.birthdayStart = birthdayStart;
    }

    public Long getBirthdayEnd() {
        return birthdayEnd;
    }

    public void setBirthdayEnd(Long birthdayEnd) {
        this.birthdayEnd = birthdayEnd;
    }

    public Integer getCareerId() {
        return careerId;
    }

    public void setCareerId(Integer careerId) {
        this.careerId = careerId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Set<Integer> getCareerIdSet() {
        return careerIdSet;
    }

    public void setCareerIdSet(Set<Integer> careerIdSet) {
        this.careerIdSet = careerIdSet;
    }

    public Set<Integer> getSchoolIdSet() {
        return schoolIdSet;
    }

    public void setSchoolIdSet(Set<Integer> schoolIdSet) {
        this.schoolIdSet = schoolIdSet;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Set<Integer> getLocationIdSet() {
        return locationIdSet;
    }

    public void setLocationIdSet(Set<Integer> locationIdSet) {
        this.locationIdSet = locationIdSet;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    
    public String getConfirmPassword() {
        return this.confirmPassword;
    }
    
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public AccountVo getAccount() {
        return account;
    }

    public void setAccount(AccountVo account) {
        this.account = account;
    }

    public CreditVo getCredit() {
        return credit;
    }

    public void setCredit(CreditVo credit) {
        this.credit = credit;
    }

    public Double getCouponTotal() {
        return couponTotal;
    }

    public void setCouponTotal(Double couponTotal) {
        this.couponTotal = couponTotal;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }
    
    
}
