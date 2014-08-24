package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.web.model.LocationVo;

public class LocationConverter {
    public static LocationBo fromModel(LocationVo vo) {
        if (vo == null) {
            return null;
        }
        LocationBo locationBo = new LocationBo();
        if (vo.getEnabled() != null) {
            locationBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            locationBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            locationBo.setIdSet(vo.getIdSet());
        }
        if (vo.getName() != null) {
            locationBo.setName(vo.getName());
        }
        if (vo.getValue() != null) {
            locationBo.setValue(vo.getValue());
        }
        if (vo.getCreateTime() != null) {
            locationBo.setCreateTime(vo.getCreateTime());
        } else {
            locationBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            locationBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            locationBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            locationBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            locationBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            locationBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            locationBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            locationBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            locationBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            locationBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            locationBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return locationBo;
    }

    public static LocationVo toModel(LocationBo bo) {

        if (bo == null) {
            return null;
        }
        LocationVo locationVo = new LocationVo();
//        locationVo.setCreateTime(bo.getCreateTime());
//        locationVo.setCreateTimeEnd(bo.getCreateTimeEnd());
//        locationVo.setCreateTimeStart(bo.getCreateTimeStart());
        locationVo.setEnabled(bo.getEnabled());
        locationVo.setId(bo.getId());
//        locationVo.setIdSet(bo.getIdSet());
//        locationVo.setLastModifyTime(bo.getLastModifyTime());
//        locationVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
//        locationVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        locationVo.setName(bo.getName());
        locationVo.setValue(bo.getValue());
        return locationVo;
    }
}
