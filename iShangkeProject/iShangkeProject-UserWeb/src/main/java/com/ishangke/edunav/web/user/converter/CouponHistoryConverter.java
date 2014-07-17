package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CouponHistoryBo;
import com.ishangke.edunav.web.user.model.CouponHistoryVo;

public class CouponHistoryConverter {
    public static CouponHistoryBo fromModel(CouponHistoryVo e) {
        CouponHistoryBo couponHistoryBo = new CouponHistoryBo();
        return couponHistoryBo;
    }

    public static CouponHistoryVo toModel(CouponHistoryBo bo) {
        CouponHistoryVo couponHistoryVo = new CouponHistoryVo();
        return couponHistoryVo;
    }
}
