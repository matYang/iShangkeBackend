package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.ConfigurationEntityExt;

public interface ConfigurationEntityExtMapper {

    public List<ConfigurationEntityExt> listAll();

    public ConfigurationEntityExt getByName(String name);
    
    public int testAdd(ConfigurationEntityExt configurationEntityExt);
}