package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;

public interface CategoryEntityExtMapper {

    public int add(CategoryEntityExt categoryEntityExt);
    
    public void deleteById(int id);
    
    public void update(CategoryEntityExt categoryEntityExt);
    
    public int getCount();

    public List<CategoryEntityExt> list(@Param("entity")CategoryEntityExt categoryEntityExt, @Param("page") PaginationEntity page);
}
