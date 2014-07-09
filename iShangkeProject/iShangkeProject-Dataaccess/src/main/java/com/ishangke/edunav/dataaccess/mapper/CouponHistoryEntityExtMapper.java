package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.CouponHistoryEntityExt;

public interface CouponHistoryEntityExtMapper {

    public int add(CouponHistoryEntityExt couponHistoryEntityExt);
    public void deleteById(int id);
    public void update(CouponHistoryEntityExt couponHistoryEntityExt);
}
