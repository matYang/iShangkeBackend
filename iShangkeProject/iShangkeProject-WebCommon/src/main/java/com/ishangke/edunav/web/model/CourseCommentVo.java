package com.ishangke.edunav.web.model;

import java.util.Calendar;
import java.util.Set;

public class CourseCommentVo {
    private Integer id;

    private Integer userId;

    private Integer courseTemplateId;

    private String title;

    private String content;

    private Double totalRating;

    private Double conditionRating;

    private Double attitudeRating;

    private Double satisfactionRating;

    private Calendar lastModifyTime;

    private Calendar createTime;

    private Integer enabled;
    private Set<Integer> idSet;
    private Set<Integer> userIdSet;
    private Set<Integer> courseTemplateIdSet;
    private Double totalRatingStart;
    private Double totalRatingEnd;
    private Double conditionRatingStart;
    private Double conditionRatingEnd;
    private Double attitudeRatingStart;
    private Double attitudeRatingEnd;
    private Double satisfactionRatingStart;
    private Double satisfactionRatingEnd;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getCourseTemplateId() {
        return courseTemplateId;
    }
    public void setCourseTemplateId(Integer courseTemplateId) {
        this.courseTemplateId = courseTemplateId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Double getTotalRating() {
        return totalRating;
    }
    public void setTotalRating(Double totalRating) {
        this.totalRating = totalRating;
    }
    public Double getConditionRating() {
        return conditionRating;
    }
    public void setConditionRating(Double conditionRating) {
        this.conditionRating = conditionRating;
    }
    public Double getAttitudeRating() {
        return attitudeRating;
    }
    public void setAttitudeRating(Double attitudeRating) {
        this.attitudeRating = attitudeRating;
    }
    public Double getSatisfactionRating() {
        return satisfactionRating;
    }
    public void setSatisfactionRating(Double satisfactionRating) {
        this.satisfactionRating = satisfactionRating;
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
    public Set<Integer> getIdSet() {
        return idSet;
    }
    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }
    public Set<Integer> getUserIdSet() {
        return userIdSet;
    }
    public void setUserIdSet(Set<Integer> userIdSet) {
        this.userIdSet = userIdSet;
    }
    public Set<Integer> getCourseTemplateIdSet() {
        return courseTemplateIdSet;
    }
    public void setCourseTemplateIdSet(Set<Integer> courseTemplateIdSet) {
        this.courseTemplateIdSet = courseTemplateIdSet;
    }
    public Double getTotalRatingStart() {
        return totalRatingStart;
    }
    public void setTotalRatingStart(Double totalRatingStart) {
        this.totalRatingStart = totalRatingStart;
    }
    public Double getTotalRatingEnd() {
        return totalRatingEnd;
    }
    public void setTotalRatingEnd(Double totalRatingEnd) {
        this.totalRatingEnd = totalRatingEnd;
    }
    public Double getConditionRatingStart() {
        return conditionRatingStart;
    }
    public void setConditionRatingStart(Double conditionRatingStart) {
        this.conditionRatingStart = conditionRatingStart;
    }
    public Double getConditionRatingEnd() {
        return conditionRatingEnd;
    }
    public void setConditionRatingEnd(Double conditionRatingEnd) {
        this.conditionRatingEnd = conditionRatingEnd;
    }
    public Double getAttitudeRatingStart() {
        return attitudeRatingStart;
    }
    public void setAttitudeRatingStart(Double attitudeRatingStart) {
        this.attitudeRatingStart = attitudeRatingStart;
    }
    public Double getAttitudeRatingEnd() {
        return attitudeRatingEnd;
    }
    public void setAttitudeRatingEnd(Double attitudeRatingEnd) {
        this.attitudeRatingEnd = attitudeRatingEnd;
    }
    public Double getSatisfactionRatingStart() {
        return satisfactionRatingStart;
    }
    public void setSatisfactionRatingStart(Double satisfactionRatingStart) {
        this.satisfactionRatingStart = satisfactionRatingStart;
    }
    public Double getSatisfactionRatingEnd() {
        return satisfactionRatingEnd;
    }
    public void setSatisfactionRatingEnd(Double satisfactionRatingEnd) {
        this.satisfactionRatingEnd = satisfactionRatingEnd;
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
    
}
