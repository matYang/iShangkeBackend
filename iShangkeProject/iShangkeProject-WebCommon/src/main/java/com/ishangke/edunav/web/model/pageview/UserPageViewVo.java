package com.ishangke.edunav.web.model.pageview;

import java.util.List;

import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.response.JsonResponse;

public class UserPageViewVo extends JsonResponse{
    private Integer start;
    private Integer count;
    private Integer total;
    private List<UserVo> data;
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
    public List<UserVo> getData() {
        return data;
    }
    public void setData(List<UserVo> data) {
        this.data = data;
    }
}
