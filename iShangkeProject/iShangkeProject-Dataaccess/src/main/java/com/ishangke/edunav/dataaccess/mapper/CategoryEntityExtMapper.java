package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;

public interface CategoryEntityExtMapper {

    public int add(CategoryEntityExt categoryEntityExt);
    public void deleteById(int id);
    public void update(CategoryEntityExt categoryEntityExt);
}
