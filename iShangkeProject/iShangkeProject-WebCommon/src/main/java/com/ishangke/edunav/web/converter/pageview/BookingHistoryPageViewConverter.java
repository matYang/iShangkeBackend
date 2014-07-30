package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.BookingHistoryBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryPageViewBo;
import com.ishangke.edunav.web.converter.BookingHistoryConverter;
import com.ishangke.edunav.web.model.BookingHistoryVo;
import com.ishangke.edunav.web.model.pageview.BookingHistoryPageViewVo;

public class BookingHistoryPageViewConverter {
    public static BookingHistoryPageViewVo toModel(BookingHistoryPageViewBo bo) {
        BookingHistoryPageViewVo vo = new BookingHistoryPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<BookingHistoryVo> result = new ArrayList<>();
            for (BookingHistoryBo b : bo.getData()) {
                result.add(BookingHistoryConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
