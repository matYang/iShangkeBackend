package com.ishangke.edunav.server;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.ConfigurationClientSetting;
import com.ishangke.edunav.commoncontract.model.PermissionBo;
import com.ishangke.edunav.commoncontract.model.RoleBo;
import com.ishangke.edunav.commoncontract.service.ConfigurationService;
import com.ishangke.edunav.manager.CacheManager;
import com.ishangke.edunav.manager.ConfigurationManager;
import com.ishangke.edunav.manager.PermissionManager;
import com.ishangke.edunav.manager.RoleManager;
import com.ishangke.edunav.manager.common.ServiceConstants;
import com.ishangke.edunav.manager.common.ServiceEnum;
import com.ishangke.edunav.service.impl.ConfigurationServiceImpl;
import com.ishangke.edunav.util.ThriftServer;

@Component
public class ApplicationServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationServer.class);

    public static final String CONFIGURATION_SERVICE = "server";

    @Autowired
    private PermissionManager permissionManager;

    @Autowired
    private RoleManager roleManager;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private ConfigurationManager configManager;

    public void loadPermissionCache() {
        LOGGER.info("Load permissions to cache.");

        List<RoleBo> roleList = roleManager.listAll();
        if (roleList == null || roleList.size() < 1) {
            return;
        }

        int count = 0;
        List<PermissionBo> permissionList = null;
        for (RoleBo roleBo : roleList) {
            permissionList = permissionManager.listPermissionsByRoleId(roleBo.getId());

            if (permissionList == null || permissionList.size() < 1) {
                continue;
            }

            for (PermissionBo permissionBo : permissionList) {
                LOGGER.info(String.format("[PermisionCache][Role: %d : %s][Tag: %s][Url: %s]", roleBo.getId(), roleBo.getName(),
                        permissionBo.getTag(), permissionBo.getPath()));
                cacheManager.set(
                        String.format(ServiceConstants.CACHE_PARTNER_ROLE_PERMISSION, roleBo.getId(),
                                permissionBo.getTag()), 0, permissionBo);
                cacheManager.set(String.format(ServiceConstants.CACHE_PARTNER_URL, permissionBo.getPath()), 0,
                        permissionBo.getTag());
                count++;
            }
        }

        LOGGER.info("Load permissions to cache finished. Size: " + count);
    }

    public void start() {
        loadPermissionCache();
        startConfigurationService();

        /**
         * DONOT DELETE THIS CODE!! ObjectMapper jsonMapper = new
         * ObjectMapper(); String jsonString =
         * configManager.getByName(CONFIGURATION_SERVICE).getConfigData();
         * List<ThriftServerSetting> thriftServerSettings = null; try {
         * thriftServerSettings = jsonMapper.readValue(jsonString, new
         * TypeReference<List<ThriftServerSetting>>() { }); } catch (Exception
         * e) { LOGGER.warn("Thrift server start error.", e); }
         */

        for (ServiceEnum serverSetting : ServiceEnum.values()) {
            ThriftServer server = new ThriftServer(serverSetting.getPort(), serverSetting.getProcessorClass(),
                    serverSetting.getHandlerClass());
            LOGGER.info("[Server] " + serverSetting.getName());
            server.startServer();
        }
    }

    private void startConfigurationService() {
        ConfigurationClientSetting setting = ConfigurationClientSetting.getSetting();

        ThriftServer server = new ThriftServer(setting.getPort(), ConfigurationService.Processor.class,
                ConfigurationServiceImpl.class);
        LOGGER.info("[Server] Configuration");
        server.startServer();
    }

    /**
     * Service start method
     * 
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath*:applicationContext-*.xml");
        ThriftServer.setApplicationContext(applicationContext);

        applicationContext.getBean(ApplicationServer.class).start();

        LOGGER.info("[Server] Server finished starting.");
    }
}
