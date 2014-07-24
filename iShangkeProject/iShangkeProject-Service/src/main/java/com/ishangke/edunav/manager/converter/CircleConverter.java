package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.dataaccess.model.CircleEntityExt;

public class CircleConverter {
    public static CircleBo toBo(CircleEntityExt e) {
        CircleBo circleBo = new CircleBo();
        circleBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        circleBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        circleBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        circleBo.setEnabled(e.getEnabled());
        circleBo.setId(e.getId());
        circleBo.setIdSet(e.getIdSet());
        circleBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        circleBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        circleBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        circleBo.setName(e.getName());
        circleBo.setValue(e.getValue());
        return circleBo;
    }

    public static CircleEntityExt fromBo(CircleBo bo) {
        CircleEntityExt circleEntityExt = new CircleEntityExt();
        circleEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        circleEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        circleEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        circleEntityExt.setEnabled(bo.getEnabled());
        circleEntityExt.setId(bo.getId());
        circleEntityExt.setIdSet(bo.getIdSet());
        circleEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        circleEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        circleEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        circleEntityExt.setName(bo.getName());
        circleEntityExt.setValue(bo.getValue());
        return circleEntityExt;
    }
}
