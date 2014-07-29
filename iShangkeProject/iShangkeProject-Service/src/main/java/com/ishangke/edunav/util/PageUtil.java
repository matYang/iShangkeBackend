package com.ishangke.edunav.util;

import com.ishangke.edunav.commoncontract.model.PaginationBo;

public class PageUtil {
    
    private static final int OFFSET = 0;
    private static final int SIZE = Integer.MAX_VALUE;
    
    public static PaginationBo getPage(PaginationBo page) {
        if (page == null) {
            page = new PaginationBo();
            page.offset = OFFSET;
            page.size = SIZE;
        }
        return page;
    }
    
}
