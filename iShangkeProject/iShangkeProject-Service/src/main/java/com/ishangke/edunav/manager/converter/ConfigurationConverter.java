package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.ConfigurationBo;
import com.ishangke.edunav.dataaccess.model.ConfigurationEntityExt;

public class ConfigurationConverter {
    public static ConfigurationBo toBo(ConfigurationEntityExt e) {
        ConfigurationBo ConfigurationBo = new ConfigurationBo();
        if (e.getConfigData() != null) {
            ConfigurationBo.setConfigData(e.getConfigData());
        }
        if (e.getId() != null) {
            ConfigurationBo.setId(e.getId());
        }
        if (e.getName() != null) {
            ConfigurationBo.setName(e.getName());
        }
        return ConfigurationBo;
    }

    public static ConfigurationEntityExt fromBo(ConfigurationBo bo) {
        ConfigurationEntityExt ConfigurationEntityExt = new ConfigurationEntityExt();
        ConfigurationEntityExt.setConfigData(bo.getConfigData());
        ConfigurationEntityExt.setId(bo.getId());
        ConfigurationEntityExt.setName(bo.getName());
        return ConfigurationEntityExt;
    }
}
