package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.dataaccess.model.LocationEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class LocationConverter {
    public static LocationBo toBo(LocationEntityExt e) {
        LocationBo locationBo = new LocationBo();
        locationBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        locationBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        locationBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        locationBo.setEnabled(e.getEnabled());
        locationBo.setId(e.getId());
        locationBo.setIdSet(e.getIdSet());
        locationBo.setLastModifyTime(e.getLastModifyTime().getTimeInMillis());
        locationBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd().getTimeInMillis());
        locationBo.setLastModifyTimeStart(e.getLastModifyTimeStart().getTimeInMillis());
        locationBo.setName(e.getName());
        locationBo.setValue(e.getValue());
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
