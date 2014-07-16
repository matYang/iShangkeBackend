package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;

public class CategoryConverter {
    public static CategoryBo toBo(CategoryEntityExt e) {
        return new CategoryBo();
    }

    public static CategoryEntityExt fromBo(CategoryBo bo) {
        return new CategoryEntityExt();
    }
}
