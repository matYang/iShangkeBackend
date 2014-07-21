package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.ConfigurationBo;

public interface ConfigurationManager {
    public List<ConfigurationBo> listAll();
    public ConfigurationBo getByName(String name);
}
