package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.web.model.LocationVo;

public class LocationConverter {
    public static LocationBo fromModel(LocationVo vo) {
        LocationBo locationBo = new LocationBo();
        if (vo.getEnabled() != null){
            locationBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null){
            locationBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null){
            locationBo.setIdSet(vo.getIdSet());
        }
        if (vo.getName() != null){
            locationBo.setName(vo.getName());
        }
        if (vo.getValue() != null){
            locationBo.setValue(vo.getValue());
        }
        locationBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        locationBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        locationBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        locationBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        locationBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        locationBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        return locationBo;
    }

    public static LocationVo toModel(LocationBo bo) {
        LocationVo locationVo = new LocationVo();
        locationVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        locationVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        locationVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        locationVo.setEnabled(bo.getEnabled());
        locationVo.setId(bo.getId());
        locationVo.setIdSet(bo.getIdSet());
        locationVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        locationVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        locationVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        locationVo.setName(bo.getName());
        locationVo.setValue(bo.getValue());
        return locationVo;
    }
}
