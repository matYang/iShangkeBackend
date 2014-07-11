package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.BookingHistoryEntityExt;

public interface BookingHistoryEntityExtMapper {

    public int add(BookingHistoryEntityExt bookingHistoryEntityExt);
    
    public void deleteById(int id);
    
    public void update(BookingHistoryEntityExt bookingHistoryEntityExt);
    
    public int getCount();

    public List<BookingHistoryEntityExt> list(BookingHistoryEntityExt bookingHistoryEntityExt);
}
