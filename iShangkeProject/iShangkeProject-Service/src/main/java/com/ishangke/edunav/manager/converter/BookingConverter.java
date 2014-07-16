package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;

public class BookingConverter {
    public static BookingBo toBo(BookingEntityExt e) {
        return new BookingBo();
    }

    public static BookingEntityExt fromBo(BookingBo bo) {
        return new BookingEntityExt();
    }
}
