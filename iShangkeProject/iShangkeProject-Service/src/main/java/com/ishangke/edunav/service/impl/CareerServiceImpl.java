package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.CareerBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.service.CareerService;
import com.ishangke.edunav.manager.CareerManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class CareerServiceImpl implements CareerService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(CareerServiceImpl.class);

    @Autowired
    private CareerManager careerManager;

    @Override
    public List<CareerBo> query(CareerBo careerBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return careerManager.query(careerBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CAREER_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.CAREER_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

}
