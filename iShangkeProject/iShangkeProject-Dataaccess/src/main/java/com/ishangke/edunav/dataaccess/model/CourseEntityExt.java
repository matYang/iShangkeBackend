package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.CourseEntity;

public class CourseEntityExt extends CourseEntity {
    private Set<Integer> idSet;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    private Set<Integer> categoryIdSet;
    private Set<Integer> locationIdSet;
    private Set<Integer> circleIdSet;
    private Set<Integer> partnerIdSet;
    private Set<Integer> statusSet;
    private Set<Integer> courseTemplateIdSet;
    private Double priceStart;
    private Double priceEnd;
    private Double originalPriceStart;
    private Double originalPriceEnd;
    private Double cashbackStart;
    private Double cashbackEnd;
    private Integer popularityStart;
    private Integer popularityEnd;
    private Set<Integer> popularitySet;
    private Integer courseHourNumStart;
    private Integer courseHourNumEnd;
    private Set<Integer> courseHourNumSet;
    private Calendar startDateStart;
    private Calendar startDateEnd;
    private Calendar finishDateStart;
    private Calendar finishDateEnd;
    private Calendar cutoffDateStart;
    private Calendar cutoffDateEnd;
    private Calendar noRefundDateStart;
    private Calendar noRefundDateEnd;
    private Set<Integer> classTypeSet;
    private Double discountStart;
    private Double discountEnd;
    private Set<Integer> schooltimeDaySet;
    private Set<Integer> schooltimeWeekSet;

    // not being used as search criteria here
    private Double rating;
    private Integer bookingTotal;

    // concrete information
    private List<TeacherEntityExt> teacherList;
    private List<ClassPhotoEntityExt> classPhotoList;

    // placing values identified by FK here, and this is really ugly
    private String logoUrl;
    private String wholeName;
    private String instName;
    private String partnerIntro;
    private Integer partnerQualification;
    private String partnerDistinction;
    private Double partnerRating;

    private String address;
    private Double addressLat;
    private Double addressLng;
    private String categoryValue;
    private String categoryName;
    private Integer categoryRank;
    private String locationValue;
    private String locationName;
    private String circleValue;
    private String circleName;

    public Calendar getNoRefundDateStart() {
        return noRefundDateStart;
    }

    public void setNoRefundDateStart(Calendar noRefundDateStart) {
        this.noRefundDateStart = noRefundDateStart;
    }

    public Calendar getNoRefundDateEnd() {
        return noRefundDateEnd;
    }

    public void setNoRefundDateEnd(Calendar noRefundDateEnd) {
        this.noRefundDateEnd = noRefundDateEnd;
    }

    public Set<Integer> getSchooltimeDaySet() {
        return schooltimeDaySet;
    }

    public void setSchooltimeDaySet(Set<Integer> schooltimeDaySet) {
        this.schooltimeDaySet = schooltimeDaySet;
    }

    public Set<Integer> getSchooltimeWeekSet() {
        return schooltimeWeekSet;
    }

    public void setSchooltimeWeekSet(Set<Integer> schooltimeWeekSet) {
        this.schooltimeWeekSet = schooltimeWeekSet;
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

    public String getPartnerIntro() {
        return partnerIntro;
    }

    public void setPartnerIntro(String partnerIntro) {
        this.partnerIntro = partnerIntro;
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

    public Set<Integer> getCategoryIdSet() {
        return categoryIdSet;
    }

    public void setCategoryIdSet(Set<Integer> categoryIdSet) {
        this.categoryIdSet = categoryIdSet;
    }

    public Set<Integer> getLocationIdSet() {
        return locationIdSet;
    }

    public void setLocationIdSet(Set<Integer> locationIdSet) {
        this.locationIdSet = locationIdSet;
    }

    public Set<Integer> getCircleIdSet() {
        return circleIdSet;
    }

    public void setCircleIdSet(Set<Integer> circleIdSet) {
        this.circleIdSet = circleIdSet;
    }

    public Set<Integer> getPartnerIdSet() {
        return partnerIdSet;
    }

    public void setPartnerIdSet(Set<Integer> partnerIdSet) {
        this.partnerIdSet = partnerIdSet;
    }

    public Set<Integer> getStatusSet() {
        return statusSet;
    }

    public void setStatusSet(Set<Integer> statusSet) {
        this.statusSet = statusSet;
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

    public Double getPartnerRating() {
        return partnerRating;
    }

    public void setPartnerRating(Double partnerRating) {
        this.partnerRating = partnerRating;
    }

    public Double getAddressLat() {
        return addressLat;
    }

    public void setAddressLat(Double addressLat) {
        this.addressLat = addressLat;
    }

    public Double getAddressLng() {
        return addressLng;
    }

    public void setAddressLng(Double addressLng) {
        this.addressLng = addressLng;
    }

    public Set<Integer> getClassTypeSet() {
        return classTypeSet;
    }

    public void setClassTypeSet(Set<Integer> classTypeSet) {
        this.classTypeSet = classTypeSet;
    }

    public Double getDiscountStart() {
        return discountStart;
    }

    public void setDiscountStart(Double discountStart) {
        this.discountStart = discountStart;
    }

    public Double getDiscountEnd() {
        return discountEnd;
    }

    public void setDiscountEnd(Double discountEnd) {
        this.discountEnd = discountEnd;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getBookingTotal() {
        return bookingTotal;
    }

    public void setBookingTotal(Integer bookingTotal) {
        this.bookingTotal = bookingTotal;
    }

    public Set<Integer> getCourseTemplateIdSet() {
        return courseTemplateIdSet;
    }

    public void setCourseTemplateIdSet(Set<Integer> courseTemplateIdSet) {
        this.courseTemplateIdSet = courseTemplateIdSet;
    }

    public Set<Integer> getPopularitySet() {
        return popularitySet;
    }

    public void setPopularitySet(Set<Integer> popularitySet) {
        this.popularitySet = popularitySet;
    }

    public Set<Integer> getCourseHourNumSet() {
        return courseHourNumSet;
    }

    public void setCourseHourNumSet(Set<Integer> courseHourNumSet) {
        this.courseHourNumSet = courseHourNumSet;
    }

}
