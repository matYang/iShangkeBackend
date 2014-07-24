package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.web.model.CircleVo;

public class CircleConverter {
    public static CircleBo fromModel(CircleVo vo) {
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
        circleBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        circleBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        circleBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        circleBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        circleBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        circleBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        return circleBo;
    }

    public static CircleVo toModel(CircleBo bo) {
        CircleVo circleVo = new CircleVo();
        circleVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        circleVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        circleVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        circleVo.setEnabled(bo.getEnabled());
        circleVo.setId(bo.getId());
        circleVo.setIdSet(bo.getIdSet());
        circleVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        circleVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        circleVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        circleVo.setName(bo.getName());
        circleVo.setValue(bo.getValue());
        return circleVo;
    }
}
