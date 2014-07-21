package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.commoncontract.model.GroupBo;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.RoleEntityExt;
import com.ishangke.edunav.manager.GroupManager;
import com.ishangke.edunav.manager.converter.GroupConverter;
import com.ishangke.edunav.manager.exception.ManagerException;

public class GroupManagerImpl implements GroupManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupManagerImpl.class);

    @Autowired
    private GroupEntityExtMapper groupMapper;

    @Override
    public RoleEntityExt getRoleByGroupId(int groupId) {
        // TODO Auto-generated method stub
        return null;
    }

    // @Overrride
    public List<GroupBo> listGroupsByUserId(int userId) {
        List<GroupEntityExt> groupList = null;
        List<GroupBo> resultList = null;

        try {
            groupList = groupMapper.listGroupsByUserId(userId);
            for (GroupEntityExt groupPo : groupList) {
                resultList.add(GroupConverter.toBo(groupPo));
            }
            return resultList;
        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            throw new ManagerException("Group listGroupsByUserId Failed");
        }
    }

}
