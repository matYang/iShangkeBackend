package com.ishangke.edunav.web.model;

import java.util.List;
import java.util.Set;

import com.ishangke.edunav.web.response.JsonResponse;

public class GroupBuyActivityVo extends JsonResponse {
    private Integer id;
    private Long createTime;
    private Long endTime;
    private Integer status;
    private Integer courseId;
    private Set<Integer> idSet;
    private Long createTimeStart;
    private Long createTimeEnd;
    private Long endTimeStart;
    private Long endTimeEnd;
    private Set<Integer> statusSet;
    private Set<Integer> courseIdSet;
    private CourseVo course;
    private Double groupBuyPrice;
    private Double groupBuyPriceStart;
    private Double groupBuyPriceEnd;
    private List<GroupBuyPhotoVo> photoList;
    private Integer hot;
    private Set<Integer> hotSet;
    private String title;
    private Integer bookingTotal;
    
    public Integer getBookingTotal() {
        return bookingTotal;
    }
    public void setBookingTotal(Integer bookingTotal) {
        this.bookingTotal = bookingTotal;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getHot() {
        return hot;
    }
    public void setHot(Integer hot) {
        this.hot = hot;
    }
    public Set<Integer> getHotSet() {
        return hotSet;
    }
    public void setHotSet(Set<Integer> hotSet) {
        this.hotSet = hotSet;
    }
    public List<GroupBuyPhotoVo> getPhotoList() {
        return photoList;
    }
    public void setPhotoList(List<GroupBuyPhotoVo> photoList) {
        this.photoList = photoList;
    }
    public Long getEndTimeStart() {
        return endTimeStart;
    }
    public void setEndTimeStart(Long endTimeStart) {
        this.endTimeStart = endTimeStart;
    }
    public Long getEndTimeEnd() {
        return endTimeEnd;
    }
    public void setEndTimeEnd(Long endTimeEnd) {
        this.endTimeEnd = endTimeEnd;
    }
    public Double getGroupBuyPrice() {
        return groupBuyPrice;
    }
    public void setGroupBuyPrice(Double groupBuyPrice) {
        this.groupBuyPrice = groupBuyPrice;
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
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public Long getEndTime() {
        return endTime;
    }
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getCourseId() {
        return courseId;
    }
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public Set<Integer> getIdSet() {
        return idSet;
    }
    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
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
    public CourseVo getCourse() {
        return course;
    }
    public void setCourse(CourseVo course) {
        this.course = course;
    }
    
}
