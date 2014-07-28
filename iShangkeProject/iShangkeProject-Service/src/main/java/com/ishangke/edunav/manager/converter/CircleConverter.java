package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.dataaccess.model.CircleEntityExt;

public class CircleConverter {
    public static CircleBo toBo(CircleEntityExt e) {
        if (e == null) {
            return null;
        }
        CircleBo circleBo = new CircleBo();
        if (e.getEnabled() != null) {
            circleBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            circleBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            circleBo.setIdSet(e.getIdSet());
        }
        if (e.getName() != null) {
            circleBo.setName(e.getName());
        }
        if (e.getValue() != null) {
            circleBo.setValue(e.getValue());
        }
        circleBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        circleBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        circleBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart()
                .getTimeInMillis());
        circleBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        circleBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeEnd().getTimeInMillis());
        circleBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        return circleBo;
    }

    public static CircleEntityExt fromBo(CircleBo bo) {
        if (bo == null) {
            return null;
        }
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
