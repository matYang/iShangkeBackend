package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.BookingHistoryEntityExt;

public interface BookingHistoryEntityExtMapper {

    public int add(BookingHistoryEntityExt bookingHistoryEntityExt);
    public void deleteById(int id);
    public void update(BookingHistoryEntityExt bookingHistoryEntityExt);
}
