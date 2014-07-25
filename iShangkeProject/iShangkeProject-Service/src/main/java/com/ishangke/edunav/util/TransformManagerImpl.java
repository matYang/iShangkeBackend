package com.ishangke.edunav.util;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.ActionBo;
import com.ishangke.edunav.manager.CacheManager;
import com.ishangke.edunav.manager.ConfigurationManager;
import com.ishangke.edunav.manager.TransformManager;
import com.ishangke.edunav.manager.common.TransformUtil;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.transform.CurrentStatus;
import com.ishangke.edunav.manager.transform.Operation;
import com.ishangke.edunav.manager.transform.StatusEntity;
import com.ishangke.edunav.manager.transform.Transform;
import com.ishangke.edunav.manager.transform.TransformRole;

@Component
public class TransformManagerImpl implements TransformManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransformManagerImpl.class);

    @Autowired
    private ConfigurationManager configurationManager;

    @Autowired
    private CacheManager cache;

    @Override
    public List<ActionBo> getActionByRoleName(String roleName, String entityName, int currentStatus) {
        String key = Constant.TRANSFORMACTION + roleName + entityName + currentStatus;
        @SuppressWarnings("unchecked")
        ArrayList<ActionBo> tempList = (ArrayList<ActionBo>) cache.get(key);
        if (tempList != null) {
            return tempList;
        }
        LOGGER.warn(String.format("[getActionByRoleName] has no cached for status transform [roleName: %s][entityName: %s][currentStatus: %d]", roleName, entityName, currentStatus));
        String configurationJson = configurationManager.getByName(Constant.STATUSTRANSFORM).getConfigData();
        ObjectMapper mapper = new ObjectMapper();
        Transform transform;
        try {
            transform = mapper.readValue(configurationJson, Transform.class);
        } catch (Exception e) {
            LOGGER.error("[Transform] cannot read transform from configData");
            throw new ManagerException("read configDara json to object failed");
        }
        // 这个地方必须要手动new一个而不能设置为null
        // 如果设置为null，我们将无法将结果缓存到memcached中，导致每一次的查询如果结果是空，都认为是没有缓存，每次请求都会进行一次解析json（非常影响性能！！）
        ArrayList<ActionBo> actionBoList = new ArrayList<>();
        for (TransformRole t : transform.getTransformRoles()) {
            if (t.getName().equals(roleName)) {
                List<StatusEntity> statusEntitiesList = t.getEntitys();
                for (StatusEntity se : statusEntitiesList) {
                    if (se.getName().equals(entityName)) {
                        List<CurrentStatus> currentStatusList = se.getCurrentStatuses();
                        for (CurrentStatus s : currentStatusList) {
                            if (s.getStatusCode() == currentStatus) {
                                List<Operation> operationsList = s.getOperations();
                                for (Operation o : operationsList) {
                                    actionBoList.add(TransformUtil.toActionBo(o));
                                }
                            }
                        }
                    }
                }
            }
        }

        cache.set(key, 0, actionBoList);

        return actionBoList;
    }

    @Override
    public List<Operation> getOperationByRoleName(String roleName, String entityName, int currentStatus) {
        String key = Constant.TRANSFORMOPERATION + roleName + entityName + currentStatus;
        @SuppressWarnings("unchecked")
        ArrayList<Operation> tempList = (ArrayList<Operation>) cache.get(key);
        if (tempList != null) {
            return tempList;
        }
        LOGGER.warn(String.format("[getOperationByRoleName] has no cached for status transform [roleName: %s][entityName: %s][currentStatus: %d]", roleName, entityName, currentStatus));
        ArrayList<Operation> operationsList = new ArrayList<>();
        String configurationJson = configurationManager.getByName(Constant.STATUSTRANSFORM).getConfigData();
        ObjectMapper mapper = new ObjectMapper();
        Transform transform;
        try {
            transform = mapper.readValue(configurationJson, Transform.class);
            for (TransformRole t : transform.getTransformRoles()) {
                if (t.getName().equals(roleName)) {
                    List<StatusEntity> statusEntitiesList = t.getEntitys();
                    for (StatusEntity se : statusEntitiesList) {
                        if (se.getName().equals(entityName)) {
                            List<CurrentStatus> currentStatusList = se.getCurrentStatuses();
                            for (CurrentStatus s : currentStatusList) {
                                if (s.getStatusCode() == currentStatus) {
                                    operationsList = (ArrayList<Operation>) s.getOperations();
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            //发生异常不缓存结果
            LOGGER.error("[Transform] cannot read transform from configData");
            return operationsList;
        }
        cache.set(key, 0, operationsList);
        return operationsList;
    }

    @Override
    public List<Operation> listAll(String entityName) {
        String key = Constant.TRANSFORMOPERATION + Constant.ROLESYSTEMADMIN + entityName;
        @SuppressWarnings("unchecked")
        ArrayList<Operation> tempList = (ArrayList<Operation>) cache.get(key);
        if (tempList != null) {
            return tempList;
        }
        LOGGER.warn(String.format("[getOperationByRoleName] has no cached for status transform [entityName: %s]", entityName));
        String configurationJson = configurationManager.getByName(Constant.STATUSTRANSFORM).getConfigData();
        ObjectMapper mapper = new ObjectMapper();
        Transform transform;
        try {
            transform = mapper.readValue(configurationJson, Transform.class);
        } catch (Exception e) {
            LOGGER.error("[Transform] cannot read transform from configData");
            throw new ManagerException("read configDara json to object failed");
        }
        ArrayList<Operation> operationsList = new ArrayList<>();
        for (TransformRole t : transform.getTransformRoles()) {
            List<StatusEntity> statusEntitiesList = t.getEntitys();
            for (StatusEntity se : statusEntitiesList) {
                if (se.getName().equals(entityName)) {
                    List<CurrentStatus> currentStatusList = se.getCurrentStatuses();
                    for (CurrentStatus s : currentStatusList) {
                        ArrayList<Operation> temp = new ArrayList<>();
                        temp = (ArrayList<Operation>) s.getOperations();
                        for(Operation o : temp) {
                            operationsList.add(o);
                        }
                    }
                }
            }
        }
        return operationsList;
    }
}
