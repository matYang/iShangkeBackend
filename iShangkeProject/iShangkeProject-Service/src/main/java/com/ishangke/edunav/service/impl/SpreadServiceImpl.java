package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.SpreadBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.service.SpreadService;
import com.ishangke.edunav.manager.SpreadManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class SpreadServiceImpl implements SpreadService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpreadServiceImpl.class);

    @Autowired
    private SpreadManager spreadManager;

    @Override
    public SpreadBo generateCode(UserBo userBo, PartnerBo partnerBo, CourseBo courseBo, String permissionTag) throws BusinessExceptionBo,
            TException {
        try {
            return spreadManager.generateCode(userBo, partnerBo, courseBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SPREAD_GENERATECODE_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_GENERATECODE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<SpreadBo> query(SpreadBo spreadBo, UserBo userBo, PaginationBo paginationBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return spreadManager.query(spreadBo, userBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SPREAD_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadBo createSpread(SpreadBo spreadBo, PartnerBo partnerBo, CourseBo courseBo, UserBo userBo, String permissionTag)
            throws BusinessExceptionBo, TException {
        try {
            return spreadManager.createSpread(spreadBo, partnerBo, courseBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SPREAD_CREATE_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_CREATE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadBo approveSpread(SpreadBo spreadBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return spreadManager.approveSpread(spreadBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SPREAD_APPROVE_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_APPROVE_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadBo rejectSpread(SpreadBo spreadBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return spreadManager.rejectSpread(spreadBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SPREAD_REJECT_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_REJECT_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadBo cancelSpread(SpreadBo spreadBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return spreadManager.cancelSpread(spreadBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SPREAD_CANCEL_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_CANCEL_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public SpreadBo deleteSpread(SpreadBo spreadBo, UserBo userBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return spreadManager.deleteSpread(spreadBo, userBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SPREAD_DELETE_ERROR);
            exception.setMessageKey(ManagerErrorCode.SPREAD_DELETE_ERROR_KEY);
            throw exception;
        }
    }

}
