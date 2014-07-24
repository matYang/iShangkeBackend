package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.SchoolBo;
import com.ishangke.edunav.dataaccess.model.SchoolEntityExt;

public class SchoolConverter {
    public static SchoolBo toBo(SchoolEntityExt e) {
        SchoolBo schoolBo = new SchoolBo();
        schoolBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        schoolBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        schoolBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        schoolBo.setEnabled(e.getEnabled());
        schoolBo.setId(e.getId());
        schoolBo.setIdSet(e.getIdSet());
        schoolBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        schoolBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        schoolBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        schoolBo.setName(e.getName());
        schoolBo.setValue(e.getValue());
        return schoolBo;
    }

    public static SchoolEntityExt fromBo(SchoolBo bo) {
        SchoolEntityExt schoolEntityExt = new SchoolEntityExt();
        schoolEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        schoolEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        schoolEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        schoolEntityExt.setEnabled(bo.getEnabled());
        schoolEntityExt.setId(bo.getId());
        schoolEntityExt.setIdSet(bo.getIdSet());
        schoolEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        schoolEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        schoolEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        schoolEntityExt.setName(bo.getName());
        schoolEntityExt.setValue(bo.getValue());
        return schoolEntityExt;
    }
}
