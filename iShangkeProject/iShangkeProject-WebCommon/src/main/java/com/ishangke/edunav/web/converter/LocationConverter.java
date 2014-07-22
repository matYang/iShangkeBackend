package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.web.model.LocationVo;
import com.ishangke.edunav.web.common.DateUtility;

public class LocationConverter {
    public static LocationBo fromModel(LocationVo vo) {
        LocationBo locationBo = new LocationBo();
        locationBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        locationBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        locationBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        locationBo.setEnabled(vo.getEnabled());
        locationBo.setId(vo.getId());
        locationBo.setIdSet(vo.getIdSet());
        locationBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        locationBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        locationBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
        locationBo.setName(vo.getName());
        locationBo.setValue(vo.getValue());
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
