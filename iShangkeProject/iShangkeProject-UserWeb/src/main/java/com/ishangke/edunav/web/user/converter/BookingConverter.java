package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.web.user.model.BookingVo;

public class BookingConverter {
    public static BookingBo fromModel(BookingVo e) {
        BookingBo bookingBo = new BookingBo();
        return bookingBo;
    }

    public static BookingVo toModel(BookingBo bo) {
        BookingVo bookingVo = new BookingVo();
        return bookingVo;
    }
}
