package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CouponHistoryBo;
import com.ishangke.edunav.dataaccess.model.CouponHistoryEntityExt;

public class CouponHistoryConverter {
    public static CouponHistoryBo toBo(CouponHistoryEntityExt e) {
        return new CouponHistoryBo();
    }

    public static CouponHistoryEntityExt fromBo(CouponHistoryBo bo) {
        return new CouponHistoryEntityExt();
    }
}
