package com.ishangke.edunav.web.model;

import com.ishangke.edunav.web.response.JsonResponse;

public class CoursePromotionPhotoVo extends JsonResponse{
    private Integer id;
    private Integer coursePromotionId;
    private String url;
    private Integer type;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCoursePromotionId() {
        return coursePromotionId;
    }
    public void setCoursePromotionId(Integer coursePromotionId) {
        this.coursePromotionId = coursePromotionId;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    
    
}
