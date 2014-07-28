package com.ishangke.edunav.manager.common;

import com.ishangke.edunav.commoncontract.model.PaginationBo;

public class PageDefaults {
    
    private static final int OFFSET = 0;
    private static final int SIZE = 10;
    
    public static PaginationBo getPage(PaginationBo page) {
        if (page == null) {
            page = new PaginationBo();
            page.offset = OFFSET;
            page.size = SIZE;
        }
        return page;
    }
    
}
