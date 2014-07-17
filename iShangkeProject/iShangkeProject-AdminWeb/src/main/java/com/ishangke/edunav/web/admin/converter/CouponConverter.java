package com.ishangke.edunav.web.admin.converter;

import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;

public class CouponConverter {
    public static CouponBo toBo(CouponEntityExt e) {
        CouponBo couponBo = new CouponBo();
        return couponBo;
    }

    public static CouponEntityExt fromBo(CouponBo bo) {
        CouponEntityExt couponEntityExt = new CouponEntityExt();
        return couponEntityExt;
    }
}
