package com.ishangke.edunav.web.model.pageview;

import java.util.List;

import com.ishangke.edunav.web.model.CourseCommentVo;
import com.ishangke.edunav.web.response.JsonResponse;

public class CourseCommentPageViewVo extends JsonResponse{
    private Integer start;
    private Integer count;
    private Integer total;
    private List<CourseCommentVo> data;
    public Integer getStart() {
        return start;
    }
    public void setStart(Integer start) {
        this.start = start;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public List<CourseCommentVo> getData() {
        return data;
    }
    public void setData(List<CourseCommentVo> data) {
        this.data = data;
    }
}
