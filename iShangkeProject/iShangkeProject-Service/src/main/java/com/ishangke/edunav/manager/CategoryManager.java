package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;

public interface CategoryManager {
    /**
     *  本方法为查询category信息的功能<br>
     *  任意用户可以通过此方法查询所有Category
     *
     *  @param  queryUser     需要检索和过滤的CategoryBo信息
     *  @param  paginationBo  分页信息
     *
     *  @return Category实体 CategoryBo 列表
     *
     */
    public List<CategoryBo> queryCategory(CategoryBo categoryBo, PaginationBo paginationBo);
}
