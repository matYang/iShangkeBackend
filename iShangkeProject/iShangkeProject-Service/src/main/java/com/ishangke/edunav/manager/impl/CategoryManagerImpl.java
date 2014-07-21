package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.CategoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;
import com.ishangke.edunav.manager.CategoryManager;
import com.ishangke.edunav.manager.converter.CategoryConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

public class CategoryManagerImpl implements CategoryManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryManagerImpl.class);

    @Autowired
    private CategoryEntityExtMapper categoryEntityExtMapper;

    @Override
    public List<CategoryBo> queryCategory(CategoryBo categoryBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (categoryBo == null) {
            throw new ManagerException("CategoryBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // Convert
        CategoryEntityExt categoryEntity = CategoryConverter.fromBo(categoryBo);
        List<CategoryEntityExt> categoryList = null;
        List<CategoryBo> resultList = null;

        try {
            categoryList = categoryEntityExtMapper.list(categoryEntity, pageEntity);
            for (CategoryEntityExt categoryPo : categoryList) {
                resultList.add(CategoryConverter.toBo(categoryPo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("Category Query Failed");
        }
    }

}
