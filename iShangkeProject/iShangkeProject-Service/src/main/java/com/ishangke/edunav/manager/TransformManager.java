package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.ActionBo;

public interface TransformManager {
    public List<ActionBo> getActionByRoleName(String roleName, String entityName, int currentStatus);
}
