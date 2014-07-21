package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.SchoolBo;
import com.ishangke.edunav.dataaccess.model.SchoolEntityExt;
import com.ishangke.edunav.manager.common.DateUtility;

public class SchoolConverter {
    public static SchoolBo toBo(SchoolEntityExt e) {
        SchoolBo schoolBo = new SchoolBo();
        schoolBo.setCreateTime(e.getCreateTime().getTimeInMillis());
        schoolBo.setCreateTimeEnd(e.getCreateTimeEnd().getTimeInMillis());
        schoolBo.setCreateTimeStart(e.getCreateTimeStart().getTimeInMillis());
        schoolBo.setEnabled(e.getEnabled());
        schoolBo.setId(e.getId());
        schoolBo.setIdSet(e.getIdSet());
        schoolBo.setLastModifyTime(e.getLastModifyTime().getTimeInMillis());
        schoolBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd().getTimeInMillis());
        schoolBo.setLastModifyTimeStart(e.getLastModifyTimeStart().getTimeInMillis());
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
