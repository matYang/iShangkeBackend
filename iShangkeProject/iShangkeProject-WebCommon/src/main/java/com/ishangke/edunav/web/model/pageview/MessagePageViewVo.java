package com.ishangke.edunav.web.model.pageview;

import java.util.List;

import com.ishangke.edunav.web.model.MessageVo;
import com.ishangke.edunav.web.response.JsonResponse;

public class MessagePageViewVo extends JsonResponse{
    private Integer start;
    private Integer count;
    private Integer total;
    private List<MessageVo> data;
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
    public List<MessageVo> getData() {
        return data;
    }
    public void setData(List<MessageVo> data) {
        this.data = data;
    }
}
