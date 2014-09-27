package com.ishangke.edunav.util;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.PaginationBo;

public class PageUtil {
    
    private static final int OFFSET = 0;
    //最多显示80个每页
    private static final int SIZE = 80;
    
    public static PaginationBo getPage(PaginationBo page) {
        if (page == null) {
            page = new PaginationBo();
            page.offset = OFFSET;
            page.size = SIZE;
        } else {
            if (page.getSize() > SIZE || page.getSize() == Constant.DEFAULTNULL) {
                page.setSize(SIZE);
            }
            if (page.getOffset() == Constant.DEFAULTNULL) {
                page.setOffset(OFFSET);
            }
        }
        return page;
    }
    
}
