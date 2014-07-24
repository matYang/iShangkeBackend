package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.GroupBo;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.GroupManager;
import com.ishangke.edunav.manager.converter.GroupConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

@Component
public class GroupManagerImpl implements GroupManager {

    @Autowired
    private GroupEntityExtMapper groupMapper;
    
    @Autowired
    private AuthManager authManager;

    @Override
    public List<GroupBo> listGroupsByUserId(int userId) {
        List<GroupEntityExt> groupList = null;
        try {
            groupList = groupMapper.listGroupsByUserId(userId);
        } catch (Throwable t) {
            throw new ManagerException("Group listGroupsByUserId Failed", t);
        }
        
        if (groupList == null) {
            return new ArrayList<GroupBo>();
        }
        List<GroupBo> resultList = new ArrayList<GroupBo>();
        for (GroupEntityExt groupPo : groupList) {
            resultList.add(GroupConverter.toBo(groupPo));
        }
        return resultList;
    }

}
