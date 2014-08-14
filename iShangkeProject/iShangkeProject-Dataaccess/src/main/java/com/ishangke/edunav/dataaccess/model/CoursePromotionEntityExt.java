package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;

import com.ishangke.edunav.dataaccess.model.gen.CoursePromotionEntity;

public class CoursePromotionEntityExt extends CoursePromotionEntity {
    private Calendar createTimeStart;

    private Calendar startTimeStart;

    private Calendar endTimeStart; 
    
    private Calendar createTimeEnd;

    private Calendar startTimeEnd;

    private Calendar endTimeEnd;

    public Calendar getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Calendar createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Calendar getStartTimeStart() {
        return startTimeStart;
    }

    public void setStartTimeStart(Calendar startTimeStart) {
        this.startTimeStart = startTimeStart;
    }

    public Calendar getEndTimeStart() {
        return endTimeStart;
    }

    public void setEndTimeStart(Calendar endTimeStart) {
        this.endTimeStart = endTimeStart;
    }

    public Calendar getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Calendar createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public Calendar getStartTimeEnd() {
        return startTimeEnd;
    }

    public void setStartTimeEnd(Calendar startTimeEnd) {
        this.startTimeEnd = startTimeEnd;
    }

    public Calendar getEndTimeEnd() {
        return endTimeEnd;
    }

    public void setEndTimeEnd(Calendar endTimeEnd) {
        this.endTimeEnd = endTimeEnd;
    }
    
    
}
