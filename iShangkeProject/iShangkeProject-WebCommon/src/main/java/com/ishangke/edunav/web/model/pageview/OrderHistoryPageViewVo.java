package com.ishangke.edunav.web.model.pageview;

import java.util.List;

import com.ishangke.edunav.web.model.OrderHistoryVo;
import com.ishangke.edunav.web.response.JsonResponse;

public class OrderHistoryPageViewVo extends JsonResponse{
    private Integer start;
    private Integer count;
    private Integer total;
    private List<OrderHistoryVo> data;
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
    public List<OrderHistoryVo> getData() {
        return data;
    }
    public void setData(List<OrderHistoryVo> data) {
        this.data = data;
    }
}
