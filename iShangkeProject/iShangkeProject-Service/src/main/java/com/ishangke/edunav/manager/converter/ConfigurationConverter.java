package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.ConfigurationBo;
import com.ishangke.edunav.dataaccess.model.ConfigurationEntityExt;

public class ConfigurationConverter {
    public static ConfigurationBo toBo(ConfigurationEntityExt e) {
        ConfigurationBo ConfigurationBo = new ConfigurationBo();
        return ConfigurationBo;
    }

    public static ConfigurationEntityExt fromBo(ConfigurationBo bo) {
        ConfigurationEntityExt ConfigurationEntityExt = new ConfigurationEntityExt();
        return ConfigurationEntityExt;
    }
}
