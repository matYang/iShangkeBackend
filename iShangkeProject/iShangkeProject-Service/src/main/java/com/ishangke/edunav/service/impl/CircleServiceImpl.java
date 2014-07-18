package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.service.CircleService;
import com.ishangke.edunav.manager.CircleManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class CircleServiceImpl implements CircleService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(CircleServiceImpl.class);

    @Autowired
    private CircleManager circleManager;

    @Override
    public List<CircleBo> query(CircleBo circleBo, PaginationBo paginationBo) throws BusinessExceptionBo, TException {
        try {
            return circleManager.queryCircle(circleBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CIRCLE_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.CIRCLE_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

}
