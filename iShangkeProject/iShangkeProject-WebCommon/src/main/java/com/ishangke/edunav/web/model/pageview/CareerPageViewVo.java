package com.ishangke.edunav.web.model.pageview;

import java.util.List;

import com.ishangke.edunav.web.model.CareerVo;
import com.ishangke.edunav.web.response.JsonResponse;

public class CareerPageViewVo extends JsonResponse{
    private Integer start;
    private Integer count;
    private Integer total;
    private List<CareerVo> data;
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
    public List<CareerVo> getData() {
        return data;
    }
    public void setData(List<CareerVo> data) {
        this.data = data;
    }
}
