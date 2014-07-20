package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.UserGroupBo;
import com.ishangke.edunav.dataaccess.model.UserGroupEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class UserGroupConverter {
    public static UserGroupBo toBo(UserGroupEntityExt e) {
        UserGroupBo userGroupBo = new UserGroupBo();
        userGroupBo.setGroupId(e.getGroupId());
        userGroupBo.setGroupIdSet(e.getGroupIdSet());
        userGroupBo.setId(e.getId());
        userGroupBo.setIdSet(e.getIdSet());
        userGroupBo.setLastModifyTime(e.getLastModifyTime().getTimeInMillis());
        userGroupBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd().getTimeInMillis());
        userGroupBo.setLastModifyTimeStart(e.getLastModifyTimeStart().getTimeInMillis());
        userGroupBo.setUserId(e.getUserId());
        userGroupBo.setUserIdSet(e.getUserIdSet());
        return userGroupBo;
    }

    public static UserGroupEntityExt fromBo(UserGroupBo bo) {
        UserGroupEntityExt userGroupEntityExt = new UserGroupEntityExt();
        userGroupEntityExt.setGroupId(bo.getGroupId());
        userGroupEntityExt.setGroupIdSet(bo.getGroupIdSet());
        userGroupEntityExt.setId(bo.getId());
        userGroupEntityExt.setIdSet(bo.getIdSet());
        userGroupEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        userGroupEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        userGroupEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        userGroupEntityExt.setUserId(bo.getUserId());
        userGroupEntityExt.setUserIdSet(bo.getUserIdSet());
        return userGroupEntityExt;
    }
}
