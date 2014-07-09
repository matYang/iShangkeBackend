package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.CouponEntityExt;

public interface CouponEntityExtMapper {

    public int add(CouponEntityExt couponEntityExt);
    public void deleteById(int id);
    public void update(CouponEntityExt couponEntityExt);
}
