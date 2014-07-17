package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.web.user.model.BookingHistoryVo;

public class BookingHistoryConverter {
    public static BookingHistoryBo fromModel(BookingHistoryVo e) {
        BookingHistoryBo bookingHistoryBo = new BookingHistoryBo();
        return bookingHistoryBo;
    }

    public static BookingHistoryVo toModel(BookingHistoryBo bo) {
        BookingHistoryVo bookingHistoryVo = new BookingHistoryVo();
        return bookingHistoryVo;
    }
}
