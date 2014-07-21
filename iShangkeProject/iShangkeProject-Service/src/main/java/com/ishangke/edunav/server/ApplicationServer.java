package com.ishangke.edunav.server;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.PermissionBo;
import com.ishangke.edunav.commoncontract.model.RoleBo;
import com.ishangke.edunav.manager.PermissionManager;
import com.ishangke.edunav.manager.RoleManager;
import com.ishangke.edunav.manager.common.ServiceConstants;
import com.ishangke.edunav.util.CacheManager;

@Component
public class ApplicationServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationServer.class);

    @Autowired
    private PermissionManager permissionManager;

    @Autowired
    private RoleManager roleManager;

    @Autowired
    private CacheManager cacheManager;

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
                LOGGER.info(String.format("[Permision][Role: %d : %s][Tag: %s]", roleBo.getId(), roleBo.getName(),
                        permissionBo.getTag()));
                cacheManager.set(
                        String.format(ServiceConstants.CACHE_PARTNER_ROLE_PERMISSION, roleBo.getId(),
                                permissionBo.getTag()), 0, permissionBo);
                count++;
            }
        }

        LOGGER.info("Load permissions to cache finished. Size: " + count);
    }

    public void start() {
        loadPermissionCache();
    }
}
