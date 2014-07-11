package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.BookingEntityExt;

public interface BookingEntityExtMapper {

    public int add(BookingEntityExt bookingEntityExt);
    
    public void deleteById(int id);
    
    public void update(BookingEntityExt bookingEntityExt);
    
    public int getCount();

    public List<BookingEntityExt> list(BookingEntityExt bookingEntityExt);
}
