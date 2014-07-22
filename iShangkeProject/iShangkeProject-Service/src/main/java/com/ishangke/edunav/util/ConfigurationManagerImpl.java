package com.ishangke.edunav.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.ConfigurationBo;
import com.ishangke.edunav.dataaccess.mapper.ConfigurationEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.ConfigurationEntityExt;
import com.ishangke.edunav.manager.ConfigurationManager;
import com.ishangke.edunav.manager.converter.ConfigurationConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class ConfigurationManagerImpl implements ConfigurationManager {

    @Autowired
    private ConfigurationEntityExtMapper configurationEntityExtMapper;
    
    @Override
    public List<ConfigurationBo> listAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ConfigurationBo getByName(String name) {
        ConfigurationBo configurationBo = null; 
        ConfigurationEntityExt configurationEntityExt = null;
        try {
            configurationEntityExt = configurationEntityExtMapper.getByName(name);
            configurationBo = ConfigurationConverter.toBo(configurationEntityExt);
            return configurationBo;
        } catch (Throwable t) {
            throw new ManagerException("Configuration Query Failed", t);
        }
    }

}
