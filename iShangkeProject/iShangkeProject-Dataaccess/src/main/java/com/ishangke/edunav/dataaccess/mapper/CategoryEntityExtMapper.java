package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;

public interface CategoryEntityExtMapper {

    public int add(CategoryEntityExt categoryEntityExt);
    
    public void deleteById(int id);
    
    public void update(CategoryEntityExt categoryEntityExt);
    
    public int getCount();

    public List<CategoryEntityExt> list(CategoryEntityExt categoryEntityExt);
}
