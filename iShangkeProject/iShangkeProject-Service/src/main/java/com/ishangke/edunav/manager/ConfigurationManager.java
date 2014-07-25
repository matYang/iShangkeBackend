package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.ConfigurationBo;

public interface ConfigurationManager {
    List<ConfigurationBo> listAll();
    ConfigurationBo getByName(String name);
}
