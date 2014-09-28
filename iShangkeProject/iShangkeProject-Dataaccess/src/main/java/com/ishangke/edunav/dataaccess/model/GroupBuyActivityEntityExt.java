package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.GroupBuyActivityEntity;
import com.ishangke.edunav.dataaccess.model.GroupBuyActivityEntityExt;

public class GroupBuyActivityEntityExt extends GroupBuyActivityEntity {
    private Set<Integer> idSet;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    private Set<Integer> statusSet;
    private Set<Integer> courseIdSet;
    private CourseEntityExt course;
    private Double groupBuyPriceStart;
    private Double groupBuyPriceEnd;
    private Calendar endTimeStart;
    private Calendar endTimeEnd;
    private List<GroupBuyPhotoEntityExt> photoList;
    private Set<Integer> hotSet;
    private List<AddressEntityExt> addressList;
    
    public List<AddressEntityExt> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressEntityExt> addressList) {
        this.addressList = addressList;
    }

    public Set<Integer> getHotSet() {
        return hotSet;
    }

    public void setHotSet(Set<Integer> hotSet) {
        this.hotSet = hotSet;
    }

    public List<GroupBuyPhotoEntityExt> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<GroupBuyPhotoEntityExt> photoList) {
        this.photoList = photoList;
    }

    public Calendar getEndTimeStart() {
        return endTimeStart;
    }

    public void setEndTimeStart(Calendar endTimeStart) {
        this.endTimeStart = endTimeStart;
    }

    public Calendar getEndTimeEnd() {
        return endTimeEnd;
    }

    public void setEndTimeEnd(Calendar endTimeEnd) {
        this.endTimeEnd = endTimeEnd;
    }

    public Double getGroupBuyPriceStart() {
        return groupBuyPriceStart;
    }

    public void setGroupBuyPriceStart(Double groupBuyPriceStart) {
        this.groupBuyPriceStart = groupBuyPriceStart;
    }

    public Double getGroupBuyPriceEnd() {
        return groupBuyPriceEnd;
    }

    public void setGroupBuyPriceEnd(Double groupBuyPriceEnd) {
        this.groupBuyPriceEnd = groupBuyPriceEnd;
    }

    public Set<Integer> getIdSet() {
        return idSet;
    }

    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
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

    public Set<Integer> getStatusSet() {
        return statusSet;
    }

    public void setStatusSet(Set<Integer> statusSet) {
        this.statusSet = statusSet;
    }

    public Set<Integer> getCourseIdSet() {
        return courseIdSet;
    }

    public void setCourseIdSet(Set<Integer> courseIdSet) {
        this.courseIdSet = courseIdSet;
    }

    public CourseEntityExt getCourse() {
        return course;
    }

    public void setCourse(CourseEntityExt course) {
        this.course = course;
    }
}
