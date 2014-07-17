package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.ClassPhotoService;
import com.ishangke.edunav.manager.ClassPhotoManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class ClassPhotoServiceImpl implements ClassPhotoService.Iface{
	private static final Logger LOGGER = LoggerFactory.getLogger(ClassPhotoServiceImpl.class);
	
	@Autowired
	private ClassPhotoManager classPhotoManager;
	
	@Override
	public ClassPhotoBo createClassPhoto(ClassPhotoBo classPhotoBo,
			UserBo userBo) throws BusinessExceptionBo, TException {
		try{
			return classPhotoManager.createClassPhoto(classPhotoBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CLASSPHOTO_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CLASSPHOTO_CREATE_ERROR_KEY);
            throw exception;
		}
	}

	@Override
	public ClassPhotoBo updateClassPhoto(ClassPhotoBo classPhotoBo,
			UserBo userBo) throws BusinessExceptionBo, TException {
		try{
			return classPhotoManager.updateClassPhoto(classPhotoBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CLASSPHOTO_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CLASSPHOTO_UPDATE_ERROR_KEY);
            throw exception;
		}
	}

	@Override
	public ClassPhotoBo deleteClassPhoto(ClassPhotoBo classPhotoBo,
			UserBo userBo) throws BusinessExceptionBo, TException {
		try{
			return classPhotoManager.deleteClassPhoto(classPhotoBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CLASSPHOTO_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.CLASSPHOTO_DELETE_ERROR_KEY);
            throw exception;
		}
	}

	@Override
	public List<ClassPhotoBo> query(ClassPhotoBo classPhotoBo,
			PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo)
			throws BusinessExceptionBo, TException {
		try{
			return classPhotoManager.query(classPhotoBo, partnerBo, userBo, paginationBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CLASSPHOTO_QUERY_ERROR);
            exception.setMessageKey(ManagerErrorCode.CLASSPHOTO_QUERY_ERROR_KEY);
            throw exception;
		}
	}

}
