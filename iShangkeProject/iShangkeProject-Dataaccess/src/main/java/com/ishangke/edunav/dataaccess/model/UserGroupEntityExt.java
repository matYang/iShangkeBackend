package com.ishangke.edunav.dataaccess.model;

import java.util.Calendar;

import com.ishangke.edunav.dataaccess.model.gen.UserGroupEntity;

public class UserGroupEntityExt extends UserGroupEntity {

    private Integer idStart;
    private Integer idEnd;
    private Integer userIdStart;
    private Integer userIdEnd;
    private Integer groupIdStart;
    private Integer groupIdEnd;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;  
    
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
    public Integer getUserIdStart() {
        return userIdStart;
    }
    public void setUserIdStart(Integer userIdStart) {
        this.userIdStart = userIdStart;
    }
    public Integer getUserIdEnd() {
        return userIdEnd;
    }
    public void setUserIdEnd(Integer userIdEnd) {
        this.userIdEnd = userIdEnd;
    }
    public Integer getGroupIdStart() {
        return groupIdStart;
    }
    public void setGroupIdStart(Integer groupIdStart) {
        this.groupIdStart = groupIdStart;
    }
    public Integer getGroupIdEnd() {
        return groupIdEnd;
    }
    public void setGroupIdEnd(Integer groupIdEnd) {
        this.groupIdEnd = groupIdEnd;
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
}
