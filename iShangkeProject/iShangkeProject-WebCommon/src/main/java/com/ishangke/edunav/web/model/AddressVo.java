package com.ishangke.edunav.web.model;

import java.util.Set;

import com.ishangke.edunav.web.response.JsonResponse;

public class AddressVo extends JsonResponse{
    private Integer id;
    private Integer partnerId;
    private String detail;
    private Double lat;
    private Double lng;
    private Long lastModifyTime;
    private Long createTime;
    private Integer enabled;
    private Set<Integer> idSet;
    private Set<Integer> partnerIdSet;
    private Double latStart;
    private Double latEnd;
    private Double lngStart;
    private Double lngEnd;
    private Long lastModifyTimeStart;
    private Long lastModifyTimeEnd;
    private Long createTimeStart;
    private Long createTimeEnd;
    private Integer  locationId;
    private Integer  circleId;
    private String realAddress;
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
    public Integer getLocationId() {
        return locationId;
    }
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
    public Integer getCircleId() {
        return circleId;
    }
    public void setCircleId(Integer circleId) {
        this.circleId = circleId;
    }
    public String getRealAddress() {
        return realAddress;
    }
    public void setRealAddress(String realAddress) {
        this.realAddress = realAddress;
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
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPartnerId() {
        return partnerId;
    }
    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public Double getLat() {
        return lat;
    }
    public void setLat(Double lat) {
        this.lat = lat;
    }
    public Double getLng() {
        return lng;
    }
    public void setLng(Double lng) {
        this.lng = lng;
    }
    public Long getLastModifyTime() {
        return lastModifyTime;
    }
    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
    public Long getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public Integer getEnabled() {
        return enabled;
    }
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
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
    public Long getLastModifyTimeStart() {
        return lastModifyTimeStart;
    }
    public void setLastModifyTimeStart(Long lastModifyTimeStart) {
        this.lastModifyTimeStart = lastModifyTimeStart;
    }
    public Long getLastModifyTimeEnd() {
        return lastModifyTimeEnd;
    }
    public void setLastModifyTimeEnd(Long lastModifyTimeEnd) {
        this.lastModifyTimeEnd = lastModifyTimeEnd;
    }
    public Long getCreateTimeStart() {
        return createTimeStart;
    }
    public void setCreateTimeStart(Long createTimeStart) {
        this.createTimeStart = createTimeStart;
    }
    public Long getCreateTimeEnd() {
        return createTimeEnd;
    }
    public void setCreateTimeEnd(Long createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
    
}
