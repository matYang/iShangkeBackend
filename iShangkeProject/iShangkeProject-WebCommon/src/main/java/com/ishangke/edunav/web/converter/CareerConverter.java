package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CareerBo;
import com.ishangke.edunav.web.model.CareerVo;

public class CareerConverter {
    public static CareerBo fromModel(CareerVo vo) {
        if (vo == null) {
            return null;
        }
        CareerBo careerBo = new CareerBo();
        if (vo.getEnabled() != null) {
            careerBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            careerBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            careerBo.setIdSet(vo.getIdSet());
        }
        if (vo.getName() != null) {
            careerBo.setName(vo.getName());
        }
        if (vo.getValue() != null) {
            careerBo.setValue(vo.getValue());
        }
        careerBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        careerBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd()
                .getTimeInMillis());
        careerBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart()
                .getTimeInMillis());
        careerBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime()
                .getTimeInMillis());
        careerBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeEnd().getTimeInMillis());
        careerBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo
                .getLastModifyTimeStart().getTimeInMillis());
        return careerBo;
    }

    public static CareerVo toModel(CareerBo bo) {
        if (bo == null) {
            return null;
        }
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
