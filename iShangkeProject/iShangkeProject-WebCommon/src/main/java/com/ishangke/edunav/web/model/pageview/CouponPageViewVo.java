package com.ishangke.edunav.web.model.pageview;

import java.util.List;

import com.ishangke.edunav.web.model.CouponVo;

public class CouponPageViewVo {
    private Integer start;
    private Integer count;
    private Integer total;
    private List<CouponVo> data;
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
    public List<CouponVo> getData() {
        return data;
    }
    public void setData(List<CouponVo> data) {
        this.data = data;
    }
}
