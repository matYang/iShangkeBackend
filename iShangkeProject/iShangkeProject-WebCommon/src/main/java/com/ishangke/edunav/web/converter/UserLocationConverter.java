package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.UserLocationBo;
import com.ishangke.edunav.web.model.UserLocationVo;

public class UserLocationConverter {
    public static UserLocationBo fromModel(UserLocationVo vo) {
        UserLocationBo userLocationBo = new UserLocationBo();
        userLocationBo.setId(vo.getId());
        userLocationBo.setIdSet(vo.getIdSet());
        userLocationBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        userLocationBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        userLocationBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        userLocationBo.setLocationId(vo.getLocationId());
        userLocationBo.setLocationIdSet(vo.getLocationIdSet());
        userLocationBo.setUserId(vo.getUserId());
        userLocationBo.setUserIdSet(vo.getUserIdSet());
        return userLocationBo;
    }

    public static UserLocationVo toModel(UserLocationBo bo) {
        UserLocationVo userLocationVo = new UserLocationVo();
        userLocationVo.setId(bo.getId());
        userLocationVo.setIdSet(bo.getIdSet());
        userLocationVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        userLocationVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        userLocationVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        userLocationVo.setLocationId(bo.getLocationId());
        userLocationVo.setLocationIdSet(bo.getLocationIdSet());
        userLocationVo.setUserId(bo.getUserId());
        userLocationVo.setUserIdSet(bo.getUserIdSet());
        return userLocationVo;
    }
}
