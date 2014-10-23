package com.ishangke.edunav.web.model;

import com.ishangke.edunav.web.response.JsonResponse;

public class PartnerCategoryVo extends JsonResponse {
    private Integer id;
    private Integer partnerId;
    private Integer categoryId;
    
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
    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    
    
}
