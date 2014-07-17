package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.ResponseBo;
import com.ishangke.edunav.commoncontract.service.CategoryService;
import com.ishangke.edunav.manager.CategoryManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class CategoryServiceImpl implements CategoryService.Iface{

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	private CategoryManager categoryManager;

	@Override
	public List<CategoryBo> query(CategoryBo categoryBo, PaginationBo paginationBo)
			throws BusinessExceptionBo, TException {
		try{
			return categoryManager.queryCategory(categoryBo, paginationBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CATEGORY_QUERY_ERROR);
            exception.setMessageKey(ManagerErrorCode.CATEGORY_QUERY_ERROR_KEY);
            throw exception;
		}
	}
	
}
