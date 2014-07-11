package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CouponHistoryEntityExt;

public interface CouponHistoryEntityExtMapper {

    public int add(CouponHistoryEntityExt couponHistoryEntityExt);
    
    public void deleteById(int id);
    
    public void update(CouponHistoryEntityExt couponHistoryEntityExt);
    
    public int getCount();

    public List<CouponHistoryEntityExt> list(@Param("entity")CouponHistoryEntityExt couponHistoryEntityExt, @Param("page") PaginationEntity page);
}
