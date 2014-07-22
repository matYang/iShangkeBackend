package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.AddressService;
import com.ishangke.edunav.manager.AddressManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class AddressServiceImpl implements AddressService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityServiceImpl.class);

    @Autowired
    private AddressManager addressManager;

    @Override
    public AddressBo createAddress(AddressBo addressBo, UserBo userBo, PartnerBo partnerBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return addressManager.createAddress(addressBo, userBo, partnerBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ADDRESS_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ADDRESS_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public AddressBo updateAddress(AddressBo addressBo, UserBo userBo, PartnerBo partnerBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return addressManager.updateAddress(addressBo, userBo, partnerBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ADDRESS_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ADDRESS_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public AddressBo deleteAddress(AddressBo addressBo, UserBo userBo, PartnerBo partnerBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return addressManager.deleteAddress(addressBo, userBo, partnerBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ADDRESS_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.ADDRESS_DELETE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<AddressBo> query(AddressBo addressBo, UserBo userBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return addressManager.query(addressBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ADDRESS_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.ADDRESS_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

}
