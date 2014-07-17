package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;
import java.util.Set;

import com.ishangke.edunav.dataaccess.model.gen.CourseCommentEntity;

public class CourseCommentEntityExt extends CourseCommentEntity {
    private Integer idStart;
    private Integer idEnd;
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

    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
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
