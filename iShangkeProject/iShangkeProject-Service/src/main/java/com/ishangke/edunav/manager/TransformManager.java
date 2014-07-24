package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.ActionBo;
import com.ishangke.edunav.manager.transform.Operation;

public interface TransformManager {
    public List<ActionBo> getActionByRoleName(String roleName, String entityName, int currentStatus);
    
    public List<Operation> getOperationByRoleName(String roleName, String entityName, int currentStatus);
    
    public List<Operation> listAll(String entityName);
}
