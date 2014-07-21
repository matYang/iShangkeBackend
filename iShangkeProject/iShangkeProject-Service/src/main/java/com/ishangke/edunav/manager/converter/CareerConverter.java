package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.CareerBo;
import com.ishangke.edunav.dataaccess.model.CareerEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class CareerConverter {
    public static CareerBo toBo(CareerEntityExt e) {
        CareerBo careerBo = new CareerBo();
        careerBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        careerBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        careerBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        careerBo.setEnabled(e.getEnabled());
        careerBo.setId(e.getId());
        careerBo.setIdSet(e.getIdSet());
        careerBo.setLastModifyTime(e.getLastModifyTime().getTimeInMillis());
        careerBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd().getTimeInMillis());
        careerBo.setLastModifyTimeStart(e.getLastModifyTimeStart().getTimeInMillis());
        careerBo.setName(e.getName());
        careerBo.setValue(e.getValue());
        return careerBo;
    }

    public static CareerEntityExt fromBo(CareerBo bo) {
        CareerEntityExt careerEntityExt = new CareerEntityExt();
        careerEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        careerEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        careerEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        careerEntityExt.setEnabled(bo.getEnabled());
        careerEntityExt.setId(bo.getId());
        careerEntityExt.setIdSet(bo.getIdSet());
        careerEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        careerEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        careerEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        careerEntityExt.setName(bo.getName());
        careerEntityExt.setValue(bo.getValue());
        return careerEntityExt;
    }
}
