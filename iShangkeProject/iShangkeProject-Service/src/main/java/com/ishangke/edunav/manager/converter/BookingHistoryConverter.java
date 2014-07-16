package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.dataaccess.model.BookingHistoryEntityExt;

public class BookingHistoryConverter {
    public static BookingHistoryBo toBo(BookingHistoryEntityExt e) {
        return new BookingHistoryBo();
    }

    public static BookingHistoryEntityExt fromBo(BookingHistoryBo bo) {
        return new BookingHistoryEntityExt();
    }
}
