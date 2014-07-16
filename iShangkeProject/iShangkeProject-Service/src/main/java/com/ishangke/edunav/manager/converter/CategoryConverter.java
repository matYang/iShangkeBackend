package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;

public class CategoryConverter {
    public static CategoryBo toBo(CategoryEntityExt e) {
        CategoryBo categoryBo = new CategoryBo();
        return categoryBo;
    }

    public static CategoryEntityExt fromBo(CategoryBo bo) {
        CategoryEntityExt categoryEntityExt = new CategoryEntityExt();
        return categoryEntityExt;
    }
}
