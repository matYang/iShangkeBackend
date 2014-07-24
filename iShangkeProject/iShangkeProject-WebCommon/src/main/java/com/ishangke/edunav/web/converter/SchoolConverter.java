package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.SchoolBo;
import com.ishangke.edunav.web.model.SchoolVo;

public class SchoolConverter {
    public static SchoolBo fromModel(SchoolVo vo) {
        SchoolBo schoolBo = new SchoolBo();
        schoolBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        schoolBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        schoolBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        schoolBo.setEnabled(vo.getEnabled());
        schoolBo.setId(vo.getId());
        schoolBo.setIdSet(vo.getIdSet());
        schoolBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        schoolBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        schoolBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
        schoolBo.setName(vo.getName());
        schoolBo.setValue(vo.getValue());
        return schoolBo;
    }

    public static SchoolVo toModel(SchoolBo bo) {
        SchoolVo schoolVo = new SchoolVo();
        schoolVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        schoolVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        schoolVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        schoolVo.setEnabled(bo.getEnabled());
        schoolVo.setId(bo.getId());
        schoolVo.setIdSet(bo.getIdSet());
        schoolVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        schoolVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        schoolVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        schoolVo.setName(bo.getName());
        schoolVo.setValue(bo.getValue());
        return schoolVo;
    }
}
