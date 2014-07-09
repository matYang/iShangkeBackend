package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.BookingEntityExt;

public interface BookingEntityExtMapper {

    public int add(BookingEntityExt bookingEntityExt);
    public void deleteById(int id);
    public void update(BookingEntityExt bookingEntityExt);
}
