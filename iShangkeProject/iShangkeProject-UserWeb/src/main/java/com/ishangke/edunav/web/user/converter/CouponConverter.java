package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.web.user.model.CouponVo;

public class CouponConverter {
    public static CouponBo fromModel(CouponVo e) {
        CouponBo couponBo = new CouponBo();
        return couponBo;
    }

    public static CouponVo toModel(CouponBo bo) {
        CouponVo couponVo = new CouponVo();
        return couponVo;
    }
}
