package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.web.model.CircleVo;

public class CircleConverter {
    public static CircleBo fromModel(CircleVo vo) {
        if (vo == null) {
            return null;
        }
        CircleBo circleBo = new CircleBo();
        if (vo.getEnabled() != null) {
            circleBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            circleBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            circleBo.setIdSet(vo.getIdSet());
        }
        if (vo.getName() != null) {
            circleBo.setName(vo.getName());
        }
        if (vo.getValue() != null) {
            circleBo.setValue(vo.getValue());
        }
        if (vo.getCreateTime() != null) {
            circleBo.setCreateTime(vo.getCreateTime());
        } else {
            circleBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            circleBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            circleBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            circleBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            circleBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            circleBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            circleBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            circleBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            circleBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            circleBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            circleBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return circleBo;
    }

    public static CircleVo toModel(CircleBo bo) {
        if (bo == null) {
            return null;
        }
        CircleVo circleVo = new CircleVo();
        circleVo.setCreateTime(bo.getCreateTime());
        circleVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        circleVo.setCreateTimeStart(bo.getCreateTimeStart());
        circleVo.setEnabled(bo.getEnabled());
        circleVo.setId(bo.getId());
        circleVo.setIdSet(bo.getIdSet());
        circleVo.setLastModifyTime(bo.getLastModifyTime());
        circleVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
        circleVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        circleVo.setName(bo.getName());
        circleVo.setValue(bo.getValue());
        return circleVo;
    }
}
