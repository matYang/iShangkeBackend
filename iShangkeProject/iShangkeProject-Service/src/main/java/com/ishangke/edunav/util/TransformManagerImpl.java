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
        String key = roleName + entityName + currentStatus;
        @SuppressWarnings("unchecked")
        ArrayList<ActionBo> tempList = (ArrayList<ActionBo>) cache.get(key);
        if (tempList != null) {
            return tempList;
        }
        LOGGER.warn(String.format("[Transform] has no cached for status transform [roleName: %s][entityName: %s][currentStatus: %d]", roleName, entityName, currentStatus));
        String configurationJson = configurationManager.getByName(Constant.STATUSTRANSFORM).getConfigData();
        ObjectMapper mapper = new ObjectMapper();
        Transform transform;
        try {
            transform = mapper.readValue(configurationJson, Transform.class);
        } catch (Exception e) {
            LOGGER.error("[Transform] cannot read transform from configData");
            throw new ManagerException("read configDara json to object failed");
        }
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

}
