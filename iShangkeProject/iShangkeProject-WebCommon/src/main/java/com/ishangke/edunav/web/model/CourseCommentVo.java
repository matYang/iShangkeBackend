package com.ishangke.edunav.web.model;

import java.util.Set;

import com.ishangke.edunav.web.response.JsonResponse;

public class CourseCommentVo extends JsonResponse {
    private Integer id;

    private Integer userId;

    private Integer courseTemplateId;

    private String title;

    private String content;

    private Double totalRating;

    private Double conditionRating;

    private Double attitudeRating;

    private Double satisfactionRating;

    private Long lastModifyTime;

    private Long createTime;

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
    private Long lastModifyTimeStart;
    private Long lastModifyTimeEnd;
    private Long createTimeStart;
    private Long createTimeEnd;
    private UserVo user;

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

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

}
