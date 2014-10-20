package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.PartnerEntity;

public class PartnerEntityExt extends PartnerEntity {
    private Set<Integer> idSet;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;

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

    // concrete information
    private List<TeacherEntityExt> teacherList;
    private List<ClassPhotoEntityExt> classPhotoList;
    private List<AddressEntityExt> addressList;
    private Integer courseCount;
    private Integer teacherCount;
    private List<CategoryEntityExt> categoryList;
    private String categoryValue;
    private String circleValue;

    public String getCategoryValue() {
        return categoryValue;
    }

    public void setCategoryValue(String categoryValue) {
        this.categoryValue = categoryValue;
    }

    public String getCircleValue() {
        return circleValue;
    }

    public void setCircleValue(String circleValue) {
        this.circleValue = circleValue;
    }

    public List<CategoryEntityExt> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryEntityExt> categoryList) {
        this.categoryList = categoryList;
    }

    public Integer getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(Integer courseCount) {
        this.courseCount = courseCount;
    }

    public Integer getTeacherCount() {
        return teacherCount;
    }

    public void setTeacherCount(Integer teacherCount) {
        this.teacherCount = teacherCount;
    }

    public Set<Integer> getIdSet() {
        return idSet;
    }

    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }

    public Set<Integer> getCutoffDaySet() {
        return cutoffDaySet;
    }

    public void setCutoffDaySet(Set<Integer> cutoffDaySet) {
        this.cutoffDaySet = cutoffDaySet;
    }

    public Set<Integer> getCutoffTimeSet() {
        return cutoffTimeSet;
    }

    public void setCutoffTimeSet(Set<Integer> cutoffTimeSet) {
        this.cutoffTimeSet = cutoffTimeSet;
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

    public List<AddressEntityExt> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressEntityExt> addressList) {
        this.addressList = addressList;
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

}
