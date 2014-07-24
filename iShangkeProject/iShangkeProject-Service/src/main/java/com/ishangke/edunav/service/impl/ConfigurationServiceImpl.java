package com.ishangke.edunav.service.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.ConfigurationBo;
import com.ishangke.edunav.commoncontract.service.ConfigurationService;
import com.ishangke.edunav.manager.ConfigurationManager;
import com.ishangke.edunav.manager.common.ManagerErrorCode;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class ConfigurationServiceImpl implements ConfigurationService.Iface {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationServiceImpl.class);
    
    @Autowired
    private ConfigurationManager configManager;
    
    /**********************************************************
    *
    *   关于常用上课人 Contact
    *
    **********************************************************/
    @Override
    public ConfigurationBo getConfigurationByName(String name) throws BusinessExceptionBo, TException {
        try {
            return configManager.getByName(name);
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CONFIGURATION_GETBYNAME_ERROR);
            exception.setMessageKey(ManagerErrorCode.CONFIGURATION_GETBYNAME_ERROR_KEY);
            throw exception;
        }
    }

    @Override
    public List<ConfigurationBo> listAllConfiguration() throws BusinessExceptionBo, TException {
        try {
            return configManager.listAll();
        } catch (ManagerException e) {
            LOGGER.info(e.getMessage(), e);
            BusinessExceptionBo exception = new BusinessExceptionBo();
            exception.setErrorCode(ManagerErrorCode.CONFIGURATION_LISTALL_ERROR);
            exception.setMessageKey(ManagerErrorCode.CONFIGURATION_LISTALL_ERROR_KEY);
            throw exception;
        }
    }
}
