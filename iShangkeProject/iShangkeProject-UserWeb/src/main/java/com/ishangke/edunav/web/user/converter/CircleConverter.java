package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.web.user.model.CircleVo;
import com.ishangke.edunav.web.user.common.DateUtility;

public class CircleConverter {
    public static CircleBo fromModel(CircleVo vo) {
        CircleBo circleBo = new CircleBo();
        circleBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        circleBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        circleBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        circleBo.setEnabled(vo.getEnabled());
        circleBo.setId(vo.getId());
        circleBo.setIdSet(vo.getIdSet());
        circleBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        circleBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        circleBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
        circleBo.setName(vo.getName());
        circleBo.setValue(vo.getValue());
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
