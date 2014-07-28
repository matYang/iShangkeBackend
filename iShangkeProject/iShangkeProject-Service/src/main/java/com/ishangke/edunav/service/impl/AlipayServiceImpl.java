package com.ishangke.edunav.service.impl;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.service.AlipayService;
import com.ishangke.edunav.manager.AlipayManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class AlipayServiceImpl implements AlipayService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
    private AlipayManager alipayManager;

    @Override
    public String verify(String notify_id) throws BusinessExceptionBo, TException {
        try {
            return alipayManager.verify(notify_id);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ALIPAY_VERIFY_ERROR);
            exception.setMessageKey(ManagerErrorCode.ALIPAY_VERIFY_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public String buildFormForGet(String subject, String out_trade_no, String total_fee) throws BusinessExceptionBo, TException {
        try {
            return alipayManager.getSubmit(subject, out_trade_no, total_fee);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.ALIPAY_GET_SUBMIT_ERROR);
            exception.setMessageKey(ManagerErrorCode.ALIPAY_GET_SUBMIT_ERROR_KEY);
            throw exception;
        }
    }

}
