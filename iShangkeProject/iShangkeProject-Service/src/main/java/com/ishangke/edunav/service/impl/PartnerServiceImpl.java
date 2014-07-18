package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.PartnerService;
import com.ishangke.edunav.manager.PartnerManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class PartnerServiceImpl implements PartnerService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(PartnerServiceImpl.class);

    @Autowired
    private PartnerManager partnerManager;

    @Override
    public List<PartnerBo> query(PartnerBo partnerBo, PaginationBo paginationBo, UserBo userBo)
            throws BusinessExceptionBo, TException {
        try {
            return partnerManager.query(partnerBo, paginationBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PARTNER_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.PARTNER_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public PartnerBo queryById(PartnerBo partnerBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return partnerManager.queryById(partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PARTNER_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.PARTNER_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public PartnerBo updatePartner(PartnerBo partnerBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return partnerManager.updatePartner(partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PARTNER_UPDATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.PARTNER_UPDATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public PartnerBo createPartner(PartnerBo partnerBo, UserBo userBo) throws BusinessExceptionBo, TException {
        try {
            return partnerManager.createPartner(partnerBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.PARTNER_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.PARTNER_CREATE_ERROR_KEY);
            throw exception;
        }
    }

}
