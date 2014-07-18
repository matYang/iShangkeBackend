package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.UserLocationBo;
import com.ishangke.edunav.dataaccess.model.UserLocationEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class UserLocationConverter {
    public static UserLocationBo toBo(UserLocationEntityExt e) {
        UserLocationBo userLocationBo = new UserLocationBo();
        userLocationBo.setId(e.getId());
        userLocationBo.setIdSet(e.getIdSet());
        userLocationBo.setLastModifyTime(e.getLastModifyTime().getTimeInMillis());
        userLocationBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd().getTimeInMillis());
        userLocationBo.setLastModifyTimeStart(e.getLastModifyTimeStart().getTimeInMillis());
        userLocationBo.setLocationId(e.getLocationId());
        userLocationBo.setLocationIdSet(e.getLocationIdSet());
        userLocationBo.setUserId(e.getUserId());
        userLocationBo.setUserIdSet(e.getUserIdSet());
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
