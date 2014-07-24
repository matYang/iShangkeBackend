package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.CategoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;
import com.ishangke.edunav.manager.CategoryManager;
import com.ishangke.edunav.manager.converter.CategoryConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class CategoryManagerImpl implements CategoryManager {

    @Autowired
    private CategoryEntityExtMapper categoryMapper;

    @Override
    public List<CategoryBo> queryCategory(CategoryBo categoryBo, PaginationBo paginationBo) {
        CategoryEntityExt categoryEntity = categoryBo == null ? null : CategoryConverter.fromBo(categoryBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);

        List<CategoryEntityExt> results = null;
        try {
            results = categoryMapper.list(categoryEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("Category query failed", t);
        }

        if (results == null) {
            return new ArrayList<CategoryBo>();
        }
        List<CategoryBo> convertedResults = new ArrayList<CategoryBo>();
        for (CategoryEntityExt result : results) {
            convertedResults.add(CategoryConverter.toBo(result));
        }
        return convertedResults;
    }

}
