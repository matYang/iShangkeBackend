package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;

public interface BookingEntityExtMapper {

    public int add(BookingEntityExt bookingEntityExt);

    public void deleteById(int id);

    public void update(BookingEntityExt bookingEntityExt);

    public List<BookingEntityExt> list(
            @Param("entity") BookingEntityExt bookingEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") BookingEntityExt bookingEntityExt);

    public List<BookingEntityExt> listAll();

    public int getCount();

    public BookingEntityExt getById(int id);
    
    public List<BookingEntityExt> listByPartnerId(@Param("entity") BookingEntityExt bookingEntityExt, @Param("partnerId") int partnerId,
            @Param("page") PaginationEntity page);
    
    public int getCountByPartnerId(@Param("entity") BookingEntityExt bookingEntityExt, @Param("partnerId") int partnerId);
}
