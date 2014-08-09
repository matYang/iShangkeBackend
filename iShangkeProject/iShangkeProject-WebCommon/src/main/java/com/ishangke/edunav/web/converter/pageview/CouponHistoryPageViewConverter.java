package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.CouponHistoryBo;
import com.ishangke.edunav.commoncontract.model.CouponHistoryPageViewBo;
import com.ishangke.edunav.web.converter.CouponHistoryConverter;
import com.ishangke.edunav.web.model.CouponHistoryVo;
import com.ishangke.edunav.web.model.pageview.CouponHistoryPageViewVo;

public class CouponHistoryPageViewConverter {
    public static CouponHistoryPageViewVo toModel(CouponHistoryPageViewBo bo) {
        CouponHistoryPageViewVo vo = new CouponHistoryPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<CouponHistoryVo> result = new ArrayList<>();
            for (CouponHistoryBo b : bo.getData()) {
                result.add(CouponHistoryConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
