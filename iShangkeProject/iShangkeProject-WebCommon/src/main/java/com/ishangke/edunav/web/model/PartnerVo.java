package com.ishangke.edunav.web.model;

import java.util.List;
import java.util.Set;

import com.ishangke.edunav.web.response.JsonResponse;

public class PartnerVo extends JsonResponse {
    private Integer id;

    private String instName;

    private String logoUrl;

    private String contract;

    private Double rating;

    private Long lastModifyTime;

    private Long createTime;

    private Integer enabled;

    private String wholeName;

    private String licence;

    private String organizationNum;

    private String reference;

    private String partnerIntro;

    private String partnerDistinction;

    private String licenceImgUrl;

    private String taxRegImgUrl;

    private String eduQualificationImgUrl;

    private String hqLocation;

    private Integer uniRegLocation;

    private String hqContact;

    private String hqContactPhone;

    private String hqContactSecopt;

    private String courseContact;

    private String courseContactPhone;

    private String studentInqueryPhone;

    private String regContact;

    private String regContactPhone;

    private String regContactFax;

    private Integer cutoffDay;

    private Integer cutoffTime;

    private Integer partnerQualification;
    private Set<Integer> idSet;
    private Long lastModifyTimeStart;
    private Long lastModifyTimeEnd;
    private Long createTimeStart;
    private Long createTimeEnd;

    private Integer cutoffDayStart;
    private Integer cutoffDayEnd;
    private Set<Integer> cutoffDaySet;
    private Integer cutoffTimeStart;
    private Integer cutoffTimeEnd;
    private Set<Integer> cutoffTimeSet;
    private Integer partnerQualificationStart;
    private Integer partnerQualificationEnd;
    private Double ratingStart;
    private Double ratingEnd;
    private List<TeacherVo> teacherList;
    private List<ClassPhotoVo> classPhotoList;
    private List<AddressVo> addressList;
    
    private Integer partnerId;
    private Integer popularity;

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
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

    public String getWholeName() {
        return wholeName;
    }

    public void setWholeName(String wholeName) {
        this.wholeName = wholeName;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getOrganizationNum() {
        return organizationNum;
    }

    public void setOrganizationNum(String organizationNum) {
        this.organizationNum = organizationNum;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPartnerIntro() {
        return partnerIntro;
    }

    public void setPartnerIntro(String partnerIntro) {
        this.partnerIntro = partnerIntro;
    }

    public String getPartnerDistinction() {
        return partnerDistinction;
    }

    public void setPartnerDistinction(String partnerDistinction) {
        this.partnerDistinction = partnerDistinction;
    }

    public String getLicenceImgUrl() {
        return licenceImgUrl;
    }

    public void setLicenceImgUrl(String licenceImgUrl) {
        this.licenceImgUrl = licenceImgUrl;
    }

    public String getTaxRegImgUrl() {
        return taxRegImgUrl;
    }

    public void setTaxRegImgUrl(String taxRegImgUrl) {
        this.taxRegImgUrl = taxRegImgUrl;
    }

    public String getEduQualificationImgUrl() {
        return eduQualificationImgUrl;
    }

    public void setEduQualificationImgUrl(String eduQualificationImgUrl) {
        this.eduQualificationImgUrl = eduQualificationImgUrl;
    }

    public String getHqLocation() {
        return hqLocation;
    }

    public void setHqLocation(String hqLocation) {
        this.hqLocation = hqLocation;
    }

    public Integer getUniRegLocation() {
        return uniRegLocation;
    }

    public void setUniRegLocation(Integer uniRegLocation) {
        this.uniRegLocation = uniRegLocation;
    }

    public String getHqContact() {
        return hqContact;
    }

    public void setHqContact(String hqContact) {
        this.hqContact = hqContact;
    }

    public String getHqContactPhone() {
        return hqContactPhone;
    }

    public void setHqContactPhone(String hqContactPhone) {
        this.hqContactPhone = hqContactPhone;
    }

    public String getHqContactSecopt() {
        return hqContactSecopt;
    }

    public void setHqContactSecopt(String hqContactSecopt) {
        this.hqContactSecopt = hqContactSecopt;
    }

    public String getCourseContact() {
        return courseContact;
    }

    public void setCourseContact(String courseContact) {
        this.courseContact = courseContact;
    }

    public String getCourseContactPhone() {
        return courseContactPhone;
    }

    public void setCourseContactPhone(String courseContactPhone) {
        this.courseContactPhone = courseContactPhone;
    }

    public String getStudentInqueryPhone() {
        return studentInqueryPhone;
    }

    public void setStudentInqueryPhone(String studentInqueryPhone) {
        this.studentInqueryPhone = studentInqueryPhone;
    }

    public String getRegContact() {
        return regContact;
    }

    public void setRegContact(String regContact) {
        this.regContact = regContact;
    }

    public String getRegContactPhone() {
        return regContactPhone;
    }

    public void setRegContactPhone(String regContactPhone) {
        this.regContactPhone = regContactPhone;
    }

    public String getRegContactFax() {
        return regContactFax;
    }

    public void setRegContactFax(String regContactFax) {
        this.regContactFax = regContactFax;
    }

    public Integer getCutoffDay() {
        return cutoffDay;
    }

    public void setCutoffDay(Integer cutoffDay) {
        this.cutoffDay = cutoffDay;
    }

    public Integer getCutoffTime() {
        return cutoffTime;
    }

    public void setCutoffTime(Integer cutoffTime) {
        this.cutoffTime = cutoffTime;
    }

    public Integer getPartnerQualification() {
        return partnerQualification;
    }

    public void setPartnerQualification(Integer partnerQualification) {
        this.partnerQualification = partnerQualification;
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

    public Integer getCutoffDayStart() {
        return cutoffDayStart;
    }

    public void setCutoffDayStart(Integer cutoffDayStart) {
        this.cutoffDayStart = cutoffDayStart;
    }

    public Integer getCutoffDayEnd() {
        return cutoffDayEnd;
    }

    public void setCutoffDayEnd(Integer cutoffDayEnd) {
        this.cutoffDayEnd = cutoffDayEnd;
    }

    public Set<Integer> getCutoffDaySet() {
        return cutoffDaySet;
    }

    public void setCutoffDaySet(Set<Integer> cutoffDaySet) {
        this.cutoffDaySet = cutoffDaySet;
    }

    public Integer getCutoffTimeStart() {
        return cutoffTimeStart;
    }

    public void setCutoffTimeStart(Integer cutoffTimeStart) {
        this.cutoffTimeStart = cutoffTimeStart;
    }

    public Integer getCutoffTimeEnd() {
        return cutoffTimeEnd;
    }

    public void setCutoffTimeEnd(Integer cutoffTimeEnd) {
        this.cutoffTimeEnd = cutoffTimeEnd;
    }

    public Set<Integer> getCutoffTimeSet() {
        return cutoffTimeSet;
    }

    public void setCutoffTimeSet(Set<Integer> cutoffTimeSet) {
        this.cutoffTimeSet = cutoffTimeSet;
    }

    public Integer getPartnerQualificationStart() {
        return partnerQualificationStart;
    }

    public void setPartnerQualificationStart(Integer partnerQualificationStart) {
        this.partnerQualificationStart = partnerQualificationStart;
    }

    public Integer getPartnerQualificationEnd() {
        return partnerQualificationEnd;
    }

    public void setPartnerQualificationEnd(Integer partnerQualificationEnd) {
        this.partnerQualificationEnd = partnerQualificationEnd;
    }

    public Double getRatingStart() {
        return ratingStart;
    }

    public void setRatingStart(Double ratingStart) {
        this.ratingStart = ratingStart;
    }

    public Double getRatingEnd() {
        return ratingEnd;
    }

    public void setRatingEnd(Double ratingEnd) {
        this.ratingEnd = ratingEnd;
    }

    public List<TeacherVo> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<TeacherVo> teacherList) {
        this.teacherList = teacherList;
    }

    public List<ClassPhotoVo> getClassPhotoList() {
        return classPhotoList;
    }

    public void setClassPhotoList(List<ClassPhotoVo> classPhotoList) {
        this.classPhotoList = classPhotoList;
    }

    public List<AddressVo> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressVo> addressList) {
        this.addressList = addressList;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

}
