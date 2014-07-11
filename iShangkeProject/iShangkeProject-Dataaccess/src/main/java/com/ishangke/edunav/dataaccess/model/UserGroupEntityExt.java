package com.ishangke.edunav.dataaccess.model;

import java.util.Date;

import com.ishangke.edunav.dataaccess.model.gen.UserGroupEntity;

public class UserGroupEntityExt extends UserGroupEntity {

    private int idStart;
    private int idEnd;
    private int userIdStart;
    private int userIdEnd;
    private int groupIdStart;
    private int groupIdEnd;
    private Date lastModifyTimeStart;
    private Date lastModifyTimeEnd;  
    
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
    public int getUserIdStart() {
        return userIdStart;
    }
    public void setUserIdStart(int userIdStart) {
        this.userIdStart = userIdStart;
    }
    public int getUserIdEnd() {
        return userIdEnd;
    }
    public void setUserIdEnd(int userIdEnd) {
        this.userIdEnd = userIdEnd;
    }
    public int getGroupIdStart() {
        return groupIdStart;
    }
    public void setGroupIdStart(int groupIdStart) {
        this.groupIdStart = groupIdStart;
    }
    public int getGroupIdEnd() {
        return groupIdEnd;
    }
    public void setGroupIdEnd(int groupIdEnd) {
        this.groupIdEnd = groupIdEnd;
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
}
