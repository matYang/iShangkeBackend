package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.BookingPageViewBo;
import com.ishangke.edunav.web.converter.BookingConverter;
import com.ishangke.edunav.web.model.BookingVo;
import com.ishangke.edunav.web.model.pageview.BookingPageViewVo;

public class BookingPageViewConverter {
    public static BookingPageViewVo toModel(BookingPageViewBo bo) {
        BookingPageViewVo vo = new BookingPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<BookingVo> result = new ArrayList<>();
            for (BookingBo b : bo.getData()) {
                result.add(BookingConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
