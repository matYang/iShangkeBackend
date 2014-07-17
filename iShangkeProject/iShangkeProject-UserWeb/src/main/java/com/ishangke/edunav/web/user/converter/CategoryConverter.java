package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.web.user.model.CategoryVo;

public class CategoryConverter {
    public static CategoryBo fromModel(CategoryVo e) {
        CategoryBo categoryBo = new CategoryBo();
        return categoryBo;
    }

    public static CategoryVo toModel(CategoryBo bo) {
        CategoryVo categoryVo = new CategoryVo();
        return categoryVo;
    }
}
