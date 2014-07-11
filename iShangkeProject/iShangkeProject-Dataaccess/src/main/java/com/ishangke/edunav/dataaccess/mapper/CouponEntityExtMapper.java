package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.CouponEntityExt;

public interface CouponEntityExtMapper {

    public int add(CouponEntityExt couponEntityExt);
    
    public void deleteById(int id);
    
    public void update(CouponEntityExt couponEntityExt);
    
    public int getCount();

    public List<CouponEntityExt> list(CouponEntityExt couponEntityExt);
}
