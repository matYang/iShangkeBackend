package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.commoncontract.model.CareerBo;
import com.ishangke.edunav.web.model.CareerVo;
import com.ishangke.edunav.web.common.DateUtility;

public class CareerConverter {
    public static CareerBo fromModel(CareerVo vo) {
        CareerBo careerBo = new CareerBo();
        careerBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        careerBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        careerBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        careerBo.setEnabled(vo.getEnabled());
        careerBo.setId(vo.getId());
        careerBo.setIdSet(vo.getIdSet());
        careerBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        careerBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        careerBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
        careerBo.setName(vo.getName());
        careerBo.setValue(vo.getValue());
        return careerBo;
    }

    public static CareerVo toModel(CareerBo bo) {
        CareerVo careerVo = new CareerVo();
        careerVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        careerVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        careerVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        careerVo.setEnabled(bo.getEnabled());
        careerVo.setId(bo.getId());
        careerVo.setIdSet(bo.getIdSet());
        careerVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        careerVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        careerVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        careerVo.setName(bo.getName());
        careerVo.setValue(bo.getValue());
        return careerVo;
    }
}
