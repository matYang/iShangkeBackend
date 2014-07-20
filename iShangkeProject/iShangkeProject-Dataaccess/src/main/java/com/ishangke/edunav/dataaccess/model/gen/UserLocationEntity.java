package com.ishangke.edunav.dataaccess.model.gen;

import java.util.Calendar;

public class UserLocationEntity {
    private Integer id;

    private Integer userId;

    private Integer locationId;

    private Calendar lastModifyTime;

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

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Calendar getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Calendar lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}