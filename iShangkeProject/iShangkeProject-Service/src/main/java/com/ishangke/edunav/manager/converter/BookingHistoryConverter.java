package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.dataaccess.model.BookingHistoryEntityExt;

public class BookingHistoryConverter {
    public static BookingHistoryBo toBo(BookingHistoryEntityExt e) {
        BookingHistoryBo bookingHistoryBo = new BookingHistoryBo();
        return bookingHistoryBo;
    }

    public static BookingHistoryEntityExt fromBo(BookingHistoryBo bo) {
        BookingHistoryEntityExt bookingHistoryEntityExt = new BookingHistoryEntityExt();
        return bookingHistoryEntityExt;
    }
}
