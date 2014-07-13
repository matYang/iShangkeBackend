package com.ishangke.edunav.dataaccess.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.CourseEntity;

public class CourseEntityExt extends CourseEntity {
    private Integereger idStart;
    private Integereger idEnd;
    private Set<Integer> idSet;
    private Date lastModifyTimeBefore;
    private Date lastModifyTimeAfter;
    private Date createTimeBefore;
    private Date createTimeAfter;


    private Integer categoryIdStart;
    private Integer categoryIdEnd;
    private Set<Integer> categoryIdSet;
    private Integer locationIdStart;
    private Integer locationIdEnd;
    private Set<Integer> locationIdSet;
    private Integer circleIdStart;
    private Integer circleIdEnd;
    private Set<Integer> circleIdSet;
    private Integer priceStart;
    private Integer priceEnd;
    private Integer originalPriceStart;
    private Integer originalPriceEnd;
    private Integer cashbackStart;
    private Integer cashbackEnd;
    private Integer commissionStart;
    private Integer commissionEnd;
    private Integer serviceChargeStart;
    private Integer serviceChargeEnd;
    private Integer popularityStart;
    private Integer popularityEnd;
    private Integer classSizeStart;
    private Integer classSizeEnd;
    private Integer courseHourNumStart;
    private Integer courseHourNumEnd;
    private Date startDateStart;
    private Date startDateEnd;
    private Date finishDateStart;
    private Date finishDateEnd;
    private Date cutoffDateStart;
    private Date cutoffDateEnd;

    
    //concrete information
    private List<TeacherEntityExt> teacherList;
    private List<ClassPhotoEntityExt> classPhotoList;
    
    //placing values identified by FK here, and this is really ugly
    private String logoUrl;
    private String wholeName;
    private String instName;
    private String partnerIntegerro;
    private Integer partnerQualification;
    private String partnerDistinction;
    
    private String address;
    private String categoryValue;
    private String categoryName;
    private Integer categoryRank;
    private String locationValue;
    private String locationName;
    private String circleValue;
    private String circleName;
    

    public Integereger getIdStart() {
        return idStart;
    }

    public void setIdStart(Integereger idStart) {
        this.idStart = idStart;
    }

    public Integereger getIdEnd() {
        return idEnd;
    }

    public void setIdEnd(Integereger idEnd) {
        this.idEnd = idEnd;
    }

    public Set<Integereger> getIdSet() {
        return idSet;
    }

    public void setIdSet(Set<Integereger> idSet) {
        this.idSet = idSet;
    }

    public Date getLastModifyTimeBefore() {
        return lastModifyTimeBefore;
    }

    public void setLastModifyTimeBefore(Date lastModifyTimeBefore) {
        this.lastModifyTimeBefore = lastModifyTimeBefore;
    }

    public Date getLastModifyTimeAfter() {
        return lastModifyTimeAfter;
    }

    public void setLastModifyTimeAfter(Date lastModifyTimeAfter) {
        this.lastModifyTimeAfter = lastModifyTimeAfter;
    }

    public Date getCreateTimeBefore() {
        return createTimeBefore;
    }

    public void setCreateTimeBefore(Date createTimeBefore) {
        this.createTimeBefore = createTimeBefore;
    }

    public Date getCreateTimeAfter() {
        return createTimeAfter;
    }

    public void setCreateTimeAfter(Date createTimeAfter) {
        this.createTimeAfter = createTimeAfter;
    }

    public List<TeacherEntityExt> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<TeacherEntityExt> teacherList) {
        this.teacherList = teacherList;
    }

    public List<ClassPhotoEntityExt> getClassPhotoList() {
        return classPhotoList;
    }

    public void setClassPhotoList(List<ClassPhotoEntityExt> classPhotoList) {
        this.classPhotoList = classPhotoList;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getWholeName() {
        return wholeName;
    }

    public void setWholeName(String wholeName) {
        this.wholeName = wholeName;
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public String getPartnerIntegerro() {
        return partnerIntegerro;
    }

    public void setPartnerIntegerro(String partnerIntegerro) {
        this.partnerIntegerro = partnerIntegerro;
    }

    public Integer getPartnerQualification() {
        return partnerQualification;
    }

    public void setPartnerQualification(Integer partnerQualification) {
        this.partnerQualification = partnerQualification;
    }

    public String getPartnerDistinction() {
        return partnerDistinction;
    }

    public void setPartnerDistinction(String partnerDistinction) {
        this.partnerDistinction = partnerDistinction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategoryValue() {
        return categoryValue;
    }

    public void setCategoryValue(String categoryValue) {
        this.categoryValue = categoryValue;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryRank() {
        return categoryRank;
    }

    public void setCategoryRank(Integer categoryRank) {
        this.categoryRank = categoryRank;
    }

    public String getLocationValue() {
        return locationValue;
    }

    public void setLocationValue(String locationValue) {
        this.locationValue = locationValue;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCircleValue() {
        return circleValue;
    }

    public void setCircleValue(String circleValue) {
        this.circleValue = circleValue;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }
    
}
