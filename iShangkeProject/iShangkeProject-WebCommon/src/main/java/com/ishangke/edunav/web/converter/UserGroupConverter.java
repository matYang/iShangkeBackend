package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.UserGroupBo;
import com.ishangke.edunav.web.model.UserGroupVo;

public class UserGroupConverter {
    public static UserGroupBo fromModel(UserGroupVo vo) {
        UserGroupBo userGroupBo = new UserGroupBo();
        userGroupBo.setGroupId(vo.getGroupId());
        userGroupBo.setGroupIdSet(vo.getGroupIdSet());
        userGroupBo.setId(vo.getId());
        userGroupBo.setIdSet(vo.getIdSet());
        userGroupBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        userGroupBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        userGroupBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        userGroupBo.setUserId(vo.getUserId());
        userGroupBo.setUserIdSet(vo.getUserIdSet());
        return userGroupBo;
    }

    public static UserGroupVo toModel(UserGroupBo bo) {
        UserGroupVo userGroupVo = new UserGroupVo();
        userGroupVo.setGroupId(bo.getGroupId());
        userGroupVo.setGroupIdSet(bo.getGroupIdSet());
        userGroupVo.setId(bo.getId());
        userGroupVo.setIdSet(bo.getIdSet());
        userGroupVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        userGroupVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        userGroupVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        userGroupVo.setUserId(bo.getUserId());
        userGroupVo.setUserIdSet(bo.getUserIdSet());
        return userGroupVo;
    }
}
