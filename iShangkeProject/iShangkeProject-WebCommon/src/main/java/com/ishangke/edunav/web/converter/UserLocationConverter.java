package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.UserLocationBo;
import com.ishangke.edunav.web.model.UserLocationVo;

public class UserLocationConverter {
    public static UserLocationBo fromModel(UserLocationVo vo) {
        if (vo == null) {
            return null;
        }
        UserLocationBo userLocationBo = new UserLocationBo();
        if (vo.getId() != null) {
            userLocationBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            userLocationBo.setIdSet(vo.getIdSet());
        }
        if (vo.getLocationId() != null) {
            userLocationBo.setLocationId(vo.getLocationId());
        }
        if (vo.getLocationIdSet() != null) {
            userLocationBo.setLocationIdSet(vo.getLocationIdSet());
        }
        if (vo.getUserId() != null) {
            userLocationBo.setUserId(vo.getUserId());
        }
        if (vo.getUserIdSet() != null) {
            userLocationBo.setUserIdSet(vo.getUserIdSet());
        }
        userLocationBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime()
                .getTimeInMillis());
        userLocationBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeEnd().getTimeInMillis());
        userLocationBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeStart().getTimeInMillis());
        return userLocationBo;
    }

    public static UserLocationVo toModel(UserLocationBo bo) {
        if (bo == null) {
            return null;
        }
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
