package com.ishangke.edunav.dataaccess.model;

import java.util.Date;

import com.ishangke.edunav.dataaccess.model.gen.ActivityEntity;

public class ActivityEntityExt extends ActivityEntity {

    private int idStart;
    private int idEnd;
    private int partnerIdStart;
    private int partnerIdEnd;    
    private int courseIdStart;
    private int courseIdEnd;
    private Date startTimeStart;
    private Date startTimeEnd;
    private Date endTimeStart;
    private Date endTimeEnd;
    private int statusStart;
    private int statusEnd;
    private Date lastModifyTimeStart;
    private Date lastModifyTimeEnd;
    private Date createTimeStart;
    private Date createTimeEnd;
    
    public int getIdStart() {
        return idStart;
    }
    public void setIdStart(int idStart) {
        this.idStart = idStart;
    }
    public int getIdEnd() {
        return idEnd;
    }
    public void setIdEnd(int idEnd) {
        this.idEnd = idEnd;
    }
    public int getPartnerIdStart() {
        return partnerIdStart;
    }
    public void setPartnerIdStart(int partnerIdStart) {
        this.partnerIdStart = partnerIdStart;
    }
    public int getPartnerIdEnd() {
        return partnerIdEnd;
    }
    public void setPartnerIdEnd(int partnerIdEnd) {
        this.partnerIdEnd = partnerIdEnd;
    }
    public int getCourseIdStart() {
        return courseIdStart;
    }
    public void setCourseIdStart(int courseIdStart) {
        this.courseIdStart = courseIdStart;
    }
    public int getCourseIdEnd() {
        return courseIdEnd;
    }
    public void setCourseIdEnd(int courseIdEnd) {
        this.courseIdEnd = courseIdEnd;
    }
    public Date getStartTimeStart() {
        return startTimeStart;
    }
    public void setStartTimeStart(Date startTimeStart) {
        this.startTimeStart = startTimeStart;
    }
    public Date getStartTimeEnd() {
        return startTimeEnd;
    }
    public void setStartTimeEnd(Date startTimeEnd) {
        this.startTimeEnd = startTimeEnd;
    }
    public Date getEndTimeStart() {
        return endTimeStart;
    }
    public void setEndTimeStart(Date endTimeStart) {
        this.endTimeStart = endTimeStart;
    }
    public Date getEndTimeEnd() {
        return endTimeEnd;
    }
    public void setEndTimeEnd(Date endTimeEnd) {
        this.endTimeEnd = endTimeEnd;
    }
    public int getStatusStart() {
        return statusStart;
    }
    public void setStatusStart(int statusStart) {
        this.statusStart = statusStart;
    }
    public int getStatusEnd() {
        return statusEnd;
    }
    public void setStatusEnd(int statusEnd) {
        this.statusEnd = statusEnd;
    }
    public Date getLastModifyTimeStart() {
        return lastModifyTimeStart;
    }
    public void setLastModifyTimeStart(Date lastModifyTimeStart) {
        this.lastModifyTimeStart = lastModifyTimeStart;
    }
    public Date getLastModifyTimeEnd() {
        return lastModifyTimeEnd;
    }
    public void setLastModifyTimeEnd(Date lastModifyTimeEnd) {
        this.lastModifyTimeEnd = lastModifyTimeEnd;
    }
    public Date getCreateTimeStart() {
        return createTimeStart;
    }
    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }
    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }
    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}
