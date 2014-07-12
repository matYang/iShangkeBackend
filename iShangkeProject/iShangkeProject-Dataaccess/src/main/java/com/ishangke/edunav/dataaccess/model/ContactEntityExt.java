package com.ishangke.edunav.dataaccess.model;

import com.ishangke.edunav.dataaccess.model.gen.ContactEntity;
import java.util.Date;

public class ContactEntityExt extends ContactEntity {

	private int idStart;
    private int idEnd;
    private int userIdStart;
    private int userIdEnd;
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
