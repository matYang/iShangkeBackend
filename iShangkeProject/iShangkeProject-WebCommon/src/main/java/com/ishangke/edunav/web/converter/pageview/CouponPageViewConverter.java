package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.commoncontract.model.CouponPageViewBo;
import com.ishangke.edunav.web.converter.CouponConverter;
import com.ishangke.edunav.web.model.CouponVo;
import com.ishangke.edunav.web.model.pageview.CouponPageViewVo;

public class CouponPageViewConverter {
    public static CouponPageViewVo toModel(CouponPageViewBo bo) {
        CouponPageViewVo vo = new CouponPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<CouponVo> result = new ArrayList<>();
            for (CouponBo b : bo.getData()) {
                result.add(CouponConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
