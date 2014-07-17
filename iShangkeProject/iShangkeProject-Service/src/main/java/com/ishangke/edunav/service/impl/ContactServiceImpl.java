package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.ContactBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.ContactService;
import com.ishangke.edunav.manager.ContactManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class ContactServiceImpl implements ContactService.Iface{
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

	@Autowired
	private ContactManager contactManager;

	@Override
	public ContactBo createContact(ContactBo contactBo, UserBo userBo)
			throws BusinessExceptionBo, TException {
		try{
			return contactManager.createContact(contactBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
			exception.setErrorCode(ManagerErrorCode.CONTACT_CREATE_ERROR);
			exception.setMessageKey(ManagerErrorCode.CONTACT_CREATE_ERROR_KEY);
			throw exception;
		}
	}

	@Override
	public ContactBo updateContact(ContactBo contactBo, UserBo userBo)
			throws BusinessExceptionBo, TException {
		try{
			return contactManager.updateContact(contactBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
			exception.setErrorCode(ManagerErrorCode.CONTACT_UPDATE_ERROR);
			exception.setMessageKey(ManagerErrorCode.CONTACT_UPDATE_ERROR_KEY);
			throw exception;
		}
	}

	@Override
	public ContactBo deleteContact(ContactBo contactBo, UserBo userBo)
			throws BusinessExceptionBo, TException {
		try{
			return contactManager.deleteContact(contactBo, userBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
			exception.setErrorCode(ManagerErrorCode.CONTACT_DELETE_ERROR);
			exception.setMessageKey(ManagerErrorCode.CONTACT_DELETE_ERROR_KEY);
			throw exception;
		}
	}

	@Override
	public List<ContactBo> query(ContactBo contactBo, UserBo userBo,
			PaginationBo paginationBo) throws BusinessExceptionBo, TException {
		try{
			return contactManager.query(contactBo, userBo, paginationBo);
		}catch(ManagerException e){
			LOGGER.info(e.getMessage(), e);
			BusinessExceptionBo exception = new BusinessExceptionBo();
			exception.setErrorCode(ManagerErrorCode.CONTACT_QUERY_ERROR);
			exception.setMessageKey(ManagerErrorCode.CONTACT_QUERY_ERROR_KEY);
			throw exception;
		}
	}

}
