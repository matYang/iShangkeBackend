package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;

public interface CouponEntityExtMapper {

    public int add(CouponEntityExt couponEntityExt);

    public void deleteById(int id);

    public void update(CouponEntityExt couponEntityExt);

    public int getCount();

    public List<CouponEntityExt> list(
            @Param("entity") CouponEntityExt couponEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") CouponEntityExt couponEntityExt);
    
    public List<CouponEntityExt>listCouponByUserId(int userId);
}
