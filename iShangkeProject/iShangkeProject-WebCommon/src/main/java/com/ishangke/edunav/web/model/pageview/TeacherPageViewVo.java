package com.ishangke.edunav.web.model.pageview;

import java.util.List;

import com.ishangke.edunav.web.model.TeacherVo;
import com.ishangke.edunav.web.response.JsonResponse;

public class TeacherPageViewVo extends JsonResponse{
    private Integer start;
    private Integer count;
    private Integer total;
    private List<TeacherVo> data;
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
    public List<TeacherVo> getData() {
        return data;
    }
    public void setData(List<TeacherVo> data) {
        this.data = data;
    }
}
