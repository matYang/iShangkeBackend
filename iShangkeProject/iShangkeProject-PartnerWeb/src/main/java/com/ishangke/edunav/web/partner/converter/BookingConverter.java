package com.ishangke.edunav.web.partner.converter;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;

public class BookingConverter {
    public static BookingBo toBo(BookingEntityExt e) {
        BookingBo bookingBo = new BookingBo();
        return bookingBo;
    }

    public static BookingEntityExt fromBo(BookingBo bo) {
        BookingEntityExt bookingEntityExt = new BookingEntityExt();
        return bookingEntityExt;
    }
}
