package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;

public class CouponConverter {
    public static CouponBo toBo(CouponEntityExt e) {
        return new CouponBo();
    }

    public static CouponEntityExt fromBo(CouponBo bo) {
        return new CouponEntityExt();
    }
}
