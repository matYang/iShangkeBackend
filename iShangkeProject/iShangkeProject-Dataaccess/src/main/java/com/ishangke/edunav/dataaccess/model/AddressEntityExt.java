package com.ishangke.edunav.dataaccess.model;

import java.util.Date;

import com.ishangke.edunav.dataaccess.model.gen.AddressEntity;

public class AddressEntityExt extends AddressEntity {

    private int idStart;
    private int idEnd;
    private int partnerIdStart;
    private int partnerIdEnd;
    private int locationIdStart;
    private int locationIdEnd;
    private int circleIdStart;
    private int circleIdEnd;
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
    public int getLocationIdStart() {
        return locationIdStart;
    }
    public void setLocationIdStart(int locationIdStart) {
        this.locationIdStart = locationIdStart;
    }
    public int getLocationIdEnd() {
        return locationIdEnd;
    }
    public void setLocationIdEnd(int locationIdEnd) {
        this.locationIdEnd = locationIdEnd;
    }
    public int getCircleIdStart() {
        return circleIdStart;
    }
    public void setCircleIdStart(int circleIdStart) {
        this.circleIdStart = circleIdStart;
    }
    public int getCircleIdEnd() {
        return circleIdEnd;
    }
    public void setCircleIdEnd(int circleIdEnd) {
        this.circleIdEnd = circleIdEnd;
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
