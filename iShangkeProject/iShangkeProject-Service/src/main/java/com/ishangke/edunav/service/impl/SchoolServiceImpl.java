package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.SchoolBo;
import com.ishangke.edunav.commoncontract.service.SchoolService;
import com.ishangke.edunav.manager.SchoolManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

public class SchoolServiceImpl implements SchoolService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private SchoolManager schoolManager;

    @Override
    public List<SchoolBo> query(SchoolBo schoolBo, PaginationBo paginationBo, String permissionTag) throws BusinessExceptionBo, TException {
        try {
            return schoolManager.query(schoolBo, paginationBo);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.SCHOOL_NOTFOUND_ERROR);
            exception.setMessageKey(ManagerErrorCode.SCHOOL_NOTFOUND_ERROR_KEY);
            throw exception;
        }
    }

}
