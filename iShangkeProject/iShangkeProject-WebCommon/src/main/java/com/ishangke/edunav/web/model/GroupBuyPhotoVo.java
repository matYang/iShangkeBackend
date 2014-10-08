package com.ishangke.edunav.web.model;

import com.ishangke.edunav.web.response.JsonResponse;

public class GroupBuyPhotoVo extends JsonResponse {
    private Integer id;
    private Integer groupBuyActivityId;
    private String url;
    private Integer type;
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
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
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
