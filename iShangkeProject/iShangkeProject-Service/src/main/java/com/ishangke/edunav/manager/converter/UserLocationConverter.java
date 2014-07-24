package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.UserLocationBo;
import com.ishangke.edunav.dataaccess.model.UserLocationEntityExt;

public class UserLocationConverter {
    public static UserLocationBo toBo(UserLocationEntityExt e) {
        UserLocationBo userLocationBo = new UserLocationBo();
        userLocationBo.setId(e.getId());
        userLocationBo.setIdSet(e.getIdSet());
        userLocationBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        userLocationBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        userLocationBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
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
