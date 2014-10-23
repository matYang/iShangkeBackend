package com.ishangke.edunav.dataaccess.model;

import com.ishangke.edunav.dataaccess.model.gen.AddressEntity;
import java.util.Calendar;
import java.util.Set;

public class AddressEntityExt extends AddressEntity {
    private Set<Integer> idSet;
    private Set<Integer> partnerIdSet;
    private Double latStart;
    private Double latEnd;
    private Double lngStart;
    private Double lngEnd;
    private Calendar lastModifyTimeStart;
    private Calendar lastModifyTimeEnd;
    private Calendar createTimeStart;
    private Calendar createTimeEnd;
    private Set<Integer> locationIdSet;
    private Set<Integer> circleIdSet;
    private String locationName;
    private String circleName;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
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

    public Double getLatStart() {
        return latStart;
    }

    public void setLatStart(Double latStart) {
        this.latStart = latStart;
    }

    public Double getLatEnd() {
        return latEnd;
    }

    public void setLatEnd(Double latEnd) {
        this.latEnd = latEnd;
    }

    public Double getLngStart() {
        return lngStart;
    }

    public void setLngStart(Double lngStart) {
        this.lngStart = lngStart;
    }

    public Double getLngEnd() {
        return lngEnd;
    }

    public void setLngEnd(Double lngEnd) {
        this.lngEnd = lngEnd;
    }

}
