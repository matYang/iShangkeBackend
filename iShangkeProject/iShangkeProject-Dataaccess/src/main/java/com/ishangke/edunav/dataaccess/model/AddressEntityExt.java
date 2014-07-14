package com.ishangke.edunav.dataaccess.model;

import com.ishangke.edunav.dataaccess.model.gen.AddressEntity;
import java.util.Date;
import java.util.Set;

public class AddressEntityExt extends AddressEntity {
	private Integer idStart;
    private Integer idEnd;
    private Set<Integer> idSet;

    private Integer partnerIdStart;
    private Integer partnerIdEnd;
    private Set<Integer> partnerIdSet;
    private Integer locationIdStart;
    private Integer locationIdEnd;
    private Set<Integer> locationIdSet;
    private Integer circleIdStart;
    private Integer circleIdEnd;
    private Set<Integer> circleIdSet;

    private Date lastModifyTimeStart;
    private Date lastModifyTimeEnd;
    private Date createTimeStart;
    private Date createTimeEnd;
    
    
    
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
    public Integer getPartnerIdStart() {
        return partnerIdStart;
    }
    public void setPartnerIdStart(Integer partnerIdStart) {
        this.partnerIdStart = partnerIdStart;
    }
    public Integer getPartnerIdEnd() {
        return partnerIdEnd;
    }
    public void setPartnerIdEnd(Integer partnerIdEnd) {
        this.partnerIdEnd = partnerIdEnd;
    }
    public Integer getLocationIdStart() {
        return locationIdStart;
    }
    public void setLocationIdStart(Integer locationIdStart) {
        this.locationIdStart = locationIdStart;
    }
    public Integer getLocationIdEnd() {
        return locationIdEnd;
    }
    public void setLocationIdEnd(Integer locationIdEnd) {
        this.locationIdEnd = locationIdEnd;
    }
    public Integer getCircleIdStart() {
        return circleIdStart;
    }
    public void setCircleIdStart(Integer circleIdStart) {
        this.circleIdStart = circleIdStart;
    }
    public Integer getCircleIdEnd() {
        return circleIdEnd;
    }
    public void setCircleIdEnd(Integer circleIdEnd) {
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
    public Set<Integer> getIdSet() {
        return idSet;
    }
    public void setIdSet(Set<Integer> idSet) {
        this.idSet = idSet;
    }
    public Set<Integer> getPartnerIdSet() {
        return partnerIdSet;
    }
    public void setPartnerIdSet(Set<Integer> partnerIdSet) {
        this.partnerIdSet = partnerIdSet;
    }
    public Set<Integer> getLocationIdSet() {
        return locationIdSet;
    }
    public void setLocationIdSet(Set<Integer> locationIdSet) {
        this.locationIdSet = locationIdSet;
    }
    public Set<Integer> getCircleIdSet() {
        return circleIdSet;
    }
    public void setCircleIdSet(Set<Integer> circleIdSet) {
        this.circleIdSet = circleIdSet;
    }
    
}
