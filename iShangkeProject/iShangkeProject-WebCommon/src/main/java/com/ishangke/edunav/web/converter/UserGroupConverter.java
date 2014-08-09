package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.UserGroupBo;
import com.ishangke.edunav.web.model.UserGroupVo;

public class UserGroupConverter {
    public static UserGroupBo fromModel(UserGroupVo vo) {
        if (vo == null) {
            return null;
        }
        UserGroupBo userGroupBo = new UserGroupBo();
        if (vo.getGroupId() != null) {
            userGroupBo.setGroupId(vo.getGroupId());
        }
        if (vo.getGroupIdSet() != null) {
            userGroupBo.setGroupIdSet(vo.getGroupIdSet());
        }
        if (vo.getId() != null) {
            userGroupBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            userGroupBo.setIdSet(vo.getIdSet());
        }
        if (vo.getUserId() != null) {
            userGroupBo.setUserId(vo.getUserId());
        }
        if (vo.getUserIdSet() != null) {
            userGroupBo.setUserIdSet(vo.getUserIdSet());
        }
        if (vo.getLastModifyTime() != null) {
            userGroupBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            userGroupBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            userGroupBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            userGroupBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            userGroupBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            userGroupBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return userGroupBo;
    }

    public static UserGroupVo toModel(UserGroupBo bo) {
        if (bo == null) {
            return null;
        }
        UserGroupVo userGroupVo = new UserGroupVo();
        userGroupVo.setGroupId(bo.getGroupId());
        userGroupVo.setGroupIdSet(bo.getGroupIdSet());
        userGroupVo.setId(bo.getId());
        userGroupVo.setIdSet(bo.getIdSet());
        userGroupVo.setLastModifyTime(bo.getLastModifyTime());
        userGroupVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
        userGroupVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        userGroupVo.setUserId(bo.getUserId());
        userGroupVo.setUserIdSet(bo.getUserIdSet());
        return userGroupVo;
    }
}
