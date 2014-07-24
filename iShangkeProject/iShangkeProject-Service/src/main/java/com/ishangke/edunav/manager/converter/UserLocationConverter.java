package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.UserLocationBo;
import com.ishangke.edunav.dataaccess.model.UserLocationEntityExt;

public class UserLocationConverter {
    public static UserLocationBo toBo(UserLocationEntityExt e) {
        UserLocationBo userLocationBo = new UserLocationBo();
        if (e.getId() != null) {
            userLocationBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            userLocationBo.setIdSet(e.getIdSet());
        }
        if (e.getLocationId() != null) {
            userLocationBo.setLocationId(e.getLocationId());
        }
        if (e.getLocationIdSet() != null) {
            userLocationBo.setLocationIdSet(e.getLocationIdSet());
        }
        if (e.getUserId() != null) {
            userLocationBo.setUserId(e.getUserId());
        }
        if (e.getUserIdSet() != null) {
            userLocationBo.setUserIdSet(e.getUserIdSet());
        }
        userLocationBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        userLocationBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        userLocationBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        return userLocationBo;
    }

    public static UserLocationEntityExt fromBo(UserLocationBo bo) {
        UserLocationEntityExt userLocationEntityExt = new UserLocationEntityExt();
        userLocationEntityExt.setId(bo.getId());
        userLocationEntityExt.setIdSet(bo.getIdSet());
        userLocationEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        userLocationEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        userLocationEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        userLocationEntityExt.setLocationId(bo.getLocationId());
        userLocationEntityExt.setLocationIdSet(bo.getLocationIdSet());
        userLocationEntityExt.setUserId(bo.getUserId());
        userLocationEntityExt.setUserIdSet(bo.getUserIdSet());
        return userLocationEntityExt;
    }
}
