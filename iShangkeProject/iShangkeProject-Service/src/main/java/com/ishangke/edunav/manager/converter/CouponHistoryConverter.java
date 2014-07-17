package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CouponHistoryBo;
import com.ishangke.edunav.dataaccess.model.CouponHistoryEntityExt;

public class CouponHistoryConverter {
    public static CouponHistoryBo toBo(CouponHistoryEntityExt e) {
        CouponHistoryBo couponHistoryBo = new CouponHistoryBo();
        return couponHistoryBo;
    }

    public static CouponHistoryEntityExt fromBo(CouponHistoryBo bo) {
        CouponHistoryEntityExt couponHistoryEntityExt = new CouponHistoryEntityExt();
        return couponHistoryEntityExt;
    }
}
