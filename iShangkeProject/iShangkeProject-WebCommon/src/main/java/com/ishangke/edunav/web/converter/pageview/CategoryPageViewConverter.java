package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.CategoryPageViewBo;
import com.ishangke.edunav.web.converter.CategoryConverter;
import com.ishangke.edunav.web.model.CategoryVo;
import com.ishangke.edunav.web.model.pageview.CategoryPageViewVo;

public class CategoryPageViewConverter {
    public static CategoryPageViewVo toModel(CategoryPageViewBo bo) {
        CategoryPageViewVo vo = new CategoryPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<CategoryVo> result = new ArrayList<>();
            for (CategoryBo b : bo.getData()) {
                result.add(CategoryConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
