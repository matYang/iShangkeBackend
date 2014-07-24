package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.dataaccess.model.LocationEntityExt;

public class LocationConverter {
    public static LocationBo toBo(LocationEntityExt e) {
        LocationBo locationBo = new LocationBo();
        if (e.getEnabled() != null) {
            locationBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            locationBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            locationBo.setIdSet(e.getIdSet());
        }
        if (e.getName() != null) {
            locationBo.setName(e.getName());
        }
        if (e.getValue() != null) {
            locationBo.setValue(e.getValue());
        }
        locationBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        locationBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        locationBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        locationBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        locationBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        locationBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        return locationBo;
    }

    public static LocationEntityExt fromBo(LocationBo bo) {
        LocationEntityExt locationEntityExt = new LocationEntityExt();
        locationEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        locationEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        locationEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        locationEntityExt.setEnabled(bo.getEnabled());
        locationEntityExt.setId(bo.getId());
        locationEntityExt.setIdSet(bo.getIdSet());
        locationEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        locationEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        locationEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        locationEntityExt.setName(bo.getName());
        locationEntityExt.setValue(bo.getValue());
        return locationEntityExt;
    }
}
