package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.CourseEntity;

public class CourseEntityExt extends CourseEntity {
    private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;

    private Integer categoryIdStart;
    private Integer categoryIdEnd;
    private Set<Integer> categoryIdSet;
    private Integer locationIdStart;
    private Integer locationIdEnd;
    private Set<Integer> locationIdSet;
    private Integer circleIdStart;
    private Integer circleIdEnd;
    private Set<Integer> circleIdSet;
    private Integer partnerIdStart;
    private Integer partnerIdEnd;
    private Set<Integer> partnerIdSet;
    private Integer statusStart;
    private Integer statusEnd;
    private Set<Integer> statusSet;
    private Integer courseTemplateIdStart;
    private Integer courseTemplateIdEnd;
    private Double priceStart;
    private Double priceEnd;
    private Double originalPriceStart;
    private Double originalPriceEnd;
    private Double cashbackStart;
    private Double cashbackEnd;
    private Double commissionStart;
    private Double commissionEnd;
    private Double serviceChargeStart;
    private Double serviceChargeEnd;
    private Integer popularityStart;
    private Integer popularityEnd;
    private Integer classSizeStart;
    private Integer classSizeEnd;
    private Integer courseHourNumStart;
    private Integer courseHourNumEnd;
    private Calendar startDateStart;
    private Calendar startDateEnd;
    private Calendar finishDateStart;
    private Calendar finishDateEnd;
    private Calendar cutoffDateStart;
    private Calendar cutoffDateEnd;

    
    //concrete information
    private List<TeacherEntityExt> teacherList;
    private List<ClassPhotoEntityExt> classPhotoList;
    private Double costPerformance;
    
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
    

    public Integer getIdStart() {
        return idStart;
    }

    public void setIdStart(Integer idStart) {
        this.idStart = idStart;
    }

    public Integer getIdEnd() {
        return idEnd;
    }

    public void setIdEnd(Integer idEnd) {
        this.idEnd = idEnd;
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

    public Integer getCategoryIdStart() {
        return categoryIdStart;
    }

    public void setCategoryIdStart(Integer categoryIdStart) {
        this.categoryIdStart = categoryIdStart;
    }

    public Integer getCategoryIdEnd() {
        return categoryIdEnd;
    }

    public void setCategoryIdEnd(Integer categoryIdEnd) {
        this.categoryIdEnd = categoryIdEnd;
    }

    public Set<Integer> getCategoryIdSet() {
        return categoryIdSet;
    }

    public void setCategoryIdSet(Set<Integer> categoryIdSet) {
        this.categoryIdSet = categoryIdSet;
    }

    public Integer getLocationIdStart() {
        return locationIdStart;
    }

    public void setLocationIdStart(Integer locationIdStart) {
        this.locationIdStart = locationIdStart;
    }

    public Integer getLocationIdEnd() {
        return locationIdEnd;
    }

    public void setLocationIdEnd(Integer locationIdEnd) {
        this.locationIdEnd = locationIdEnd;
    }

    public Set<Integer> getLocationIdSet() {
        return locationIdSet;
    }

    public void setLocationIdSet(Set<Integer> locationIdSet) {
        this.locationIdSet = locationIdSet;
    }

    public Integer getCircleIdStart() {
        return circleIdStart;
    }

    public void setCircleIdStart(Integer circleIdStart) {
        this.circleIdStart = circleIdStart;
    }

    public Integer getCircleIdEnd() {
        return circleIdEnd;
    }

    public void setCircleIdEnd(Integer circleIdEnd) {
        this.circleIdEnd = circleIdEnd;
    }

    public Set<Integer> getCircleIdSet() {
        return circleIdSet;
    }

    public void setCircleIdSet(Set<Integer> circleIdSet) {
        this.circleIdSet = circleIdSet;
    }

    public Integer getPartnerIdStart() {
        return partnerIdStart;
    }

    public void setPartnerIdStart(Integer partnerIdStart) {
        this.partnerIdStart = partnerIdStart;
    }

    public Integer getPartnerIdEnd() {
        return partnerIdEnd;
    }

    public void setPartnerIdEnd(Integer partnerIdEnd) {
        this.partnerIdEnd = partnerIdEnd;
    }

    public Set<Integer> getPartnerIdSet() {
        return partnerIdSet;
    }

    public void setPartnerIdSet(Set<Integer> partnerIdSet) {
        this.partnerIdSet = partnerIdSet;
    }

    public Integer getStatusStart() {
        return statusStart;
    }

    public void setStatusStart(Integer statusStart) {
        this.statusStart = statusStart;
    }

    public Integer getStatusEnd() {
        return statusEnd;
    }

    public void setStatusEnd(Integer statusEnd) {
        this.statusEnd = statusEnd;
    }

    public Set<Integer> getStatusSet() {
        return statusSet;
    }

    public void setStatusSet(Set<Integer> statusSet) {
        this.statusSet = statusSet;
    }

    public Integer getCourseTemplateIdStart() {
        return courseTemplateIdStart;
    }

    public void setCourseTemplateIdStart(Integer courseTemplateIdStart) {
        this.courseTemplateIdStart = courseTemplateIdStart;
    }

    public Integer getCourseTemplateIdEnd() {
        return courseTemplateIdEnd;
    }

    public void setCourseTemplateIdEnd(Integer courseTemplateIdEnd) {
        this.courseTemplateIdEnd = courseTemplateIdEnd;
    }

    public Double getPriceStart() {
        return priceStart;
    }

    public void setPriceStart(Double priceStart) {
        this.priceStart = priceStart;
    }

    public Double getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(Double priceEnd) {
        this.priceEnd = priceEnd;
    }

    public Double getOriginalPriceStart() {
        return originalPriceStart;
    }

    public void setOriginalPriceStart(Double originalPriceStart) {
        this.originalPriceStart = originalPriceStart;
    }

    public Double getOriginalPriceEnd() {
        return originalPriceEnd;
    }

    public void setOriginalPriceEnd(Double originalPriceEnd) {
        this.originalPriceEnd = originalPriceEnd;
    }

    public Double getCashbackStart() {
        return cashbackStart;
    }

    public void setCashbackStart(Double cashbackStart) {
        this.cashbackStart = cashbackStart;
    }

    public Double getCashbackEnd() {
        return cashbackEnd;
    }

    public void setCashbackEnd(Double cashbackEnd) {
        this.cashbackEnd = cashbackEnd;
    }

    public Double getCommissionStart() {
        return commissionStart;
    }

    public void setCommissionStart(Double commissionStart) {
        this.commissionStart = commissionStart;
    }

    public Double getCommissionEnd() {
        return commissionEnd;
    }

    public void setCommissionEnd(Double commissionEnd) {
        this.commissionEnd = commissionEnd;
    }

    public Double getServiceChargeStart() {
        return serviceChargeStart;
    }

    public void setServiceChargeStart(Double serviceChargeStart) {
        this.serviceChargeStart = serviceChargeStart;
    }

    public Double getServiceChargeEnd() {
        return serviceChargeEnd;
    }

    public void setServiceChargeEnd(Double serviceChargeEnd) {
        this.serviceChargeEnd = serviceChargeEnd;
    }

    public Integer getPopularityStart() {
        return popularityStart;
    }

    public void setPopularityStart(Integer popularityStart) {
        this.popularityStart = popularityStart;
    }

    public Integer getPopularityEnd() {
        return popularityEnd;
    }

    public void setPopularityEnd(Integer popularityEnd) {
        this.popularityEnd = popularityEnd;
    }

    public Integer getClassSizeStart() {
        return classSizeStart;
    }

    public void setClassSizeStart(Integer classSizeStart) {
        this.classSizeStart = classSizeStart;
    }

    public Integer getClassSizeEnd() {
        return classSizeEnd;
    }

    public void setClassSizeEnd(Integer classSizeEnd) {
        this.classSizeEnd = classSizeEnd;
    }

    public Integer getCourseHourNumStart() {
        return courseHourNumStart;
    }

    public void setCourseHourNumStart(Integer courseHourNumStart) {
        this.courseHourNumStart = courseHourNumStart;
    }

    public Integer getCourseHourNumEnd() {
        return courseHourNumEnd;
    }

    public void setCourseHourNumEnd(Integer courseHourNumEnd) {
        this.courseHourNumEnd = courseHourNumEnd;
    }

    public Calendar getStartDateStart() {
        return startDateStart;
    }

    public void setStartDateStart(Calendar startDateStart) {
        this.startDateStart = startDateStart;
    }

    public Calendar getStartDateEnd() {
        return startDateEnd;
    }

    public void setStartDateEnd(Calendar startDateEnd) {
        this.startDateEnd = startDateEnd;
    }

    public Calendar getFinishDateStart() {
        return finishDateStart;
    }

    public void setFinishDateStart(Calendar finishDateStart) {
        this.finishDateStart = finishDateStart;
    }

    public Calendar getFinishDateEnd() {
        return finishDateEnd;
    }

    public void setFinishDateEnd(Calendar finishDateEnd) {
        this.finishDateEnd = finishDateEnd;
    }

    public Calendar getCutoffDateStart() {
        return cutoffDateStart;
    }

    public void setCutoffDateStart(Calendar cutoffDateStart) {
        this.cutoffDateStart = cutoffDateStart;
    }

    public Calendar getCutoffDateEnd() {
        return cutoffDateEnd;
    }

    public void setCutoffDateEnd(Calendar cutoffDateEnd) {
        this.cutoffDateEnd = cutoffDateEnd;
    }
    
    
}
