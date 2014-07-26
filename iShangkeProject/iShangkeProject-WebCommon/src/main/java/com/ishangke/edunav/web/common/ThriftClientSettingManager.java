package com.ishangke.edunav.web.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ishangke.edunav.common.ConfigurationClientSetting;
import com.ishangke.edunav.commoncontract.service.ConfigurationService;
import com.ishangke.edunav.thrift.ThriftClientSetting;

public class ThriftClientSettingManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThriftClientSettingManager.class);

    public static final String CONFIGURATION_CLIENT = "client";

    public static final Map<String, ThriftClientSetting> settingMap = new HashMap<>();

    public void start() throws TException {
        ConfigurationClientSetting configurationClientSetting = ConfigurationClientSetting.getSetting();
        ThriftClientSetting setting = new ThriftClientSetting();
        setting.setName("Configuration");
        setting.setHost(configurationClientSetting.getHost());
        setting.setPort(configurationClientSetting.getPort());
        setting.setClientClass(ConfigurationService.Client.class);
        setting.setClassString(ConfigurationService.Client.class.getName());

        // thriftClientSettings = jsonMapper.readValue(jsonString, new
        // TypeReference<List<ThriftClientSetting>>() {});
        ThriftClientSetting clientSetting = null;
        for (ClientEnum clientEnum : ClientEnum.values()) {
            try {
                clientSetting = new ThriftClientSetting();
                clientSetting.setClientClass(clientEnum.getClientClass());
                clientSetting.setHost(clientEnum.getHost());
                clientSetting.setName(clientEnum.getName());
                clientSetting.setPort(clientEnum.getPort());
                settingMap.put(clientEnum.getName(), clientSetting);
            } catch (Exception e) {
                LOGGER.warn("Thrift server start error.", e);
            }
        }

        /*
         * List<ThriftClientSetting> thriftClientSettings = new ArrayList<>();
         * try (ThriftClientFactory<Client> factory = new
         * ThriftClientFactory<>(setting)) { Client serviceClient =
         * factory.getServiceClient();
         * 
         * ObjectMapper jsonMapper = new ObjectMapper(); String jsonString =
         * serviceClient
         * .getConfigurationByName(CONFIGURATION_CLIENT).getConfigData(); try {
         * thriftClientSettings = jsonMapper.readValue(jsonString, new
         * TypeReference<List<ThriftClientSetting>>() {}); } catch (Exception e)
         * { LOGGER.warn("Thrift server start error.", e); } }
         */

//        System.out.println(settingMap);
    }
//
//    public static void main(String[] args) throws Exception {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//                "classpath*:applicationContext-*.xml");
//    }
}
