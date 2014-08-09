package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
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
        if (vo.getCreateTime() != null) {
            careerBo.setCreateTime(vo.getCreateTime());
        } else {
            careerBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            careerBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            careerBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            careerBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            careerBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            careerBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            careerBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            careerBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            careerBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            careerBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            careerBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return careerBo;
    }

    public static CareerVo toModel(CareerBo bo) {
        if (bo == null) {
            return null;
        }
        CareerVo careerVo = new CareerVo();
        careerVo.setCreateTime(bo.getCreateTime());
        careerVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        careerVo.setCreateTimeStart(bo.getCreateTimeStart());
        careerVo.setEnabled(bo.getEnabled());
        careerVo.setId(bo.getId());
        careerVo.setIdSet(bo.getIdSet());
        careerVo.setLastModifyTime(bo.getLastModifyTime());
        careerVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
        careerVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        careerVo.setName(bo.getName());
        careerVo.setValue(bo.getValue());
        return careerVo;
    }
}
