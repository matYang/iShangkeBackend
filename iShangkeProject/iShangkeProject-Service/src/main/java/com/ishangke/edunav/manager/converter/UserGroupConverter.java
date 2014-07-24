package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.UserGroupBo;
import com.ishangke.edunav.dataaccess.model.UserGroupEntityExt;

public class UserGroupConverter {
    public static UserGroupBo toBo(UserGroupEntityExt e) {
        UserGroupBo userGroupBo = new UserGroupBo();
        userGroupBo.setGroupId(e.getGroupId());
        userGroupBo.setGroupIdSet(e.getGroupIdSet());
        userGroupBo.setId(e.getId());
        userGroupBo.setIdSet(e.getIdSet());
        userGroupBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        userGroupBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        userGroupBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
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
