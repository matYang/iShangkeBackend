package com.ishangke.edunav.web.model;

import com.ishangke.edunav.web.response.JsonResponse;

public class GroupBuyAddressVo extends JsonResponse {
    private Integer id;
    private Integer groupBuyActivityId;
    private Integer addressId;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getGroupBuyActivityId() {
        return groupBuyActivityId;
    }
    public void setGroupBuyActivityId(Integer groupBuyActivityId) {
        this.groupBuyActivityId = groupBuyActivityId;
    }
    public Integer getAddressId() {
        return addressId;
    }
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
}
