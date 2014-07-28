package com.ishangke.edunav.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.PermissionBo;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.PermissionEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.RoleEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.PermissionEntityExt;
import com.ishangke.edunav.dataaccess.model.RoleEntityExt;
import com.ishangke.edunav.manager.CacheManager;
import com.ishangke.edunav.manager.PermissionManager;
import com.ishangke.edunav.manager.common.ServiceConstants;
import com.ishangke.edunav.manager.converter.PermissionConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class PermissionManagerImpl implements PermissionManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionManagerImpl.class);

    @Autowired
    private PermissionEntityExtMapper permissionMapper;

    @Autowired
    private RoleEntityExtMapper roleMapper;

    @Autowired
    private GroupEntityExtMapper groupMapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public List<PermissionBo> listAll() {
        try {
            List<PermissionBo> resultList = new ArrayList<PermissionBo>();
            List<PermissionEntityExt> permissionList = permissionMapper.listAll();
            for (PermissionEntityExt permissionPo : permissionList) {
                resultList.add(PermissionConverter.toBo(permissionPo));
            }
            return resultList;
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Permissions listByUserId Failed");
        }
    }

    @Override
    public List<PermissionBo> listPermissionsByUserId(int userId) {
        try {
            List<PermissionBo> resultList = new ArrayList<PermissionBo>();
            ;
            List<PermissionEntityExt> permissionList = permissionMapper.listPermissionsByUserId(userId);
            for (PermissionEntityExt permissionPo : permissionList) {
                resultList.add(PermissionConverter.toBo(permissionPo));
            }
            return resultList;
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Permissions listByUserId Failed");
        }
    }

    @Override
    public List<PermissionBo> listPermissionsByGroupId(int groupId) {
        try {
            List<PermissionBo> resultList = new ArrayList<PermissionBo>();
            List<PermissionEntityExt> permissionList = permissionMapper.listPermissionsByGroupId(groupId);
            for (PermissionEntityExt permissionPo : permissionList) {
                resultList.add(PermissionConverter.toBo(permissionPo));
            }
            return resultList;
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Permissions listByGroupId Failed");
        }

    }

    @Override
    public List<PermissionBo> listPermissionsByRoleId(int roleId) {

        try {
            List<PermissionBo> resultList = new ArrayList<PermissionBo>();
            List<PermissionEntityExt> permissionList = permissionMapper.listPermissionByRoleId(roleId);
            for (PermissionEntityExt permissionPo : permissionList) {
                resultList.add(PermissionConverter.toBo(permissionPo));
            }
            return resultList;
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Permissions listByRoleId Failed");
        }

    }

    @Override
    public boolean hasPermissionByRole(int roleId, String permissionTag) {
        return cacheManager.get(String.format(ServiceConstants.CACHE_PARTNER_ROLE_PERMISSION, roleId,
                resolvePermissionTag(permissionTag))) != null;
    }

    @Override
    public boolean hasPermissionByUser(int userId, String permissionTag) {
        List<RoleEntityExt> roleList = roleMapper.listRolesByUserId(userId);

        if (roleList == null || roleList.size() < 1) {
            return false;
        }
        for (RoleEntityExt roleEntity : roleList) {
            if (hasPermissionByRole(roleEntity.getId(), permissionTag)) {
                return true;
            }
        }
        return false;
    }

    private String resolvePermissionTag(String tag) {
        String result = tag;
        if (tag != null
                && (tag.startsWith("POST/") || tag.startsWith("GET/") || tag.startsWith("DELETE/") || tag
                        .startsWith("PUT/"))) {
            result = String.valueOf(cacheManager.get(String.format(ServiceConstants.CACHE_PARTNER_URL, tag)));
        }

        return result;
    }
}
