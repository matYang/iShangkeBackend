package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CareerBo;
import com.ishangke.edunav.dataaccess.model.CareerEntityExt;

public class CareerConverter {
    public static CareerBo toBo(CareerEntityExt e) {
        if (e == null) {
            return null;
        }
        CareerBo careerBo = new CareerBo();
        if (e.getEnabled() != null) {
            careerBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            careerBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            careerBo.setIdSet(e.getIdSet());
        }
        if (e.getName() != null) {
            careerBo.setName(e.getName());
        }
        if (e.getValue() != null) {
            careerBo.setValue(e.getValue());
        }
        careerBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        careerBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        careerBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart()
                .getTimeInMillis());
        careerBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        careerBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeEnd().getTimeInMillis());
        careerBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        return careerBo;
    }

    public static CareerEntityExt fromBo(CareerBo bo) {
        if (bo == null) {
            return null;
        }
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
