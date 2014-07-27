package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.UserGroupBo;
import com.ishangke.edunav.dataaccess.model.UserGroupEntityExt;

public class UserGroupConverter {
    public static UserGroupBo toBo(UserGroupEntityExt e) {
        if (e == null) {
            return null;
        }
        UserGroupBo userGroupBo = new UserGroupBo();
        if (e.getGroupId() != null) {
            userGroupBo.setGroupId(e.getGroupId());
        }
        if (e.getGroupIdSet() != null) {
            userGroupBo.setGroupIdSet(e.getGroupIdSet());
        }
        if (e.getId() != null) {
            userGroupBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            userGroupBo.setIdSet(e.getIdSet());
        }
        if (e.getUserId() != null) {
            userGroupBo.setUserId(e.getUserId());
        }
        if (e.getUserIdSet() != null) {
            userGroupBo.setUserIdSet(e.getUserIdSet());
        }
        userGroupBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        userGroupBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeEnd().getTimeInMillis());
        userGroupBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        return userGroupBo;
    }

    public static UserGroupEntityExt fromBo(UserGroupBo bo) {
        if (bo == null) {
            return null;
        }
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
