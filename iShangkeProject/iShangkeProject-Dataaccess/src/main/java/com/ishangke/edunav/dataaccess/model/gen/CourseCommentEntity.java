package com.ishangke.edunav.dataaccess.model.gen;

import java.util.Calendar;

public class CourseCommentEntity {
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

    private Integer deleted;

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
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}