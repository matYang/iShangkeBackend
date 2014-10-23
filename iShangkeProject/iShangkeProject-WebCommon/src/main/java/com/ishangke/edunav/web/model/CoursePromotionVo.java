package com.ishangke.edunav.web.model;

import java.util.List;

import com.ishangke.edunav.web.response.JsonResponse;

public class CoursePromotionVo extends JsonResponse {
    private Integer id;
    private Integer courseId;
    private Integer categoryId;
    private Long createTime;
    private Long startTime;
    private Long endTime;
    private Integer status;
    private Long createTimeStart;
    private Long startTimeStart;
    private Long endTimeStart;
    private Long createTimeEnd;
    private Long startTimeEnd;
    private Long endTimeEnd;
    private CourseVo course;
    private List<CoursePromotionPhotoVo> photoList;

    public CourseVo getCourse() {
        return course;
    }

    public void setCourse(CourseVo course) {
        this.course = course;
    }

    public List<CoursePromotionPhotoVo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<CoursePromotionPhotoVo> photoList) {
        this.photoList = photoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
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

    public Long getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Long createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Long getStartTimeStart() {
        return startTimeStart;
    }

    public void setStartTimeStart(Long startTimeStart) {
        this.startTimeStart = startTimeStart;
    }

    public Long getEndTimeStart() {
        return endTimeStart;
    }

    public void setEndTimeStart(Long endTimeStart) {
        this.endTimeStart = endTimeStart;
    }

    public Long getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Long createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public Long getStartTimeEnd() {
        return startTimeEnd;
    }

    public void setStartTimeEnd(Long startTimeEnd) {
        this.startTimeEnd = startTimeEnd;
    }

    public Long getEndTimeEnd() {
        return endTimeEnd;
    }

    public void setEndTimeEnd(Long endTimeEnd) {
        this.endTimeEnd = endTimeEnd;
    }

}
