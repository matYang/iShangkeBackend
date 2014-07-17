package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.BookingHistoryEntityExt;

public interface BookingHistoryEntityExtMapper {

    public int add(BookingHistoryEntityExt bookingHistoryEntityExt);

    public void deleteById(int id);

    public void update(BookingHistoryEntityExt bookingHistoryEntityExt);

    public List<BookingHistoryEntityExt> list(
            @Param("entity") BookingHistoryEntityExt bookingHistoryEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") BookingHistoryEntityExt bookingHistoryEntityExt);

    public List<BookingHistoryEntityExt> listAll();

    public int getCount();

    public BookingHistoryEntityExt getById(int id);
}
