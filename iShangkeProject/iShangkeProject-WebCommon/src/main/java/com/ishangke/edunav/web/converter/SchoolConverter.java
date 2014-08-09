package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.SchoolBo;
import com.ishangke.edunav.web.model.SchoolVo;

public class SchoolConverter {
    public static SchoolBo fromModel(SchoolVo vo) {
        if (vo == null) {
            return null;
        }
        SchoolBo schoolBo = new SchoolBo();
        if (vo.getEnabled() != null) {
            schoolBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            schoolBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            schoolBo.setIdSet(vo.getIdSet());
        }
        if (vo.getName() != null) {
            schoolBo.setName(vo.getName());
        }
        if (vo.getValue() != null) {
            schoolBo.setValue(vo.getValue());
        }
        if (vo.getCreateTime() != null) {
            schoolBo.setCreateTime(vo.getCreateTime());
        } else {
            schoolBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            schoolBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            schoolBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            schoolBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            schoolBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            schoolBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            schoolBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            schoolBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            schoolBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            schoolBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            schoolBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return schoolBo;
    }

    public static SchoolVo toModel(SchoolBo bo) {
        if (bo == null) {
            return null;
        }
        SchoolVo schoolVo = new SchoolVo();
        schoolVo.setCreateTime(bo.getCreateTime());
        schoolVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        schoolVo.setCreateTimeStart(bo.getCreateTimeStart());
        schoolVo.setEnabled(bo.getEnabled());
        schoolVo.setId(bo.getId());
        schoolVo.setIdSet(bo.getIdSet());
        schoolVo.setLastModifyTime(bo.getLastModifyTime());
        schoolVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
        schoolVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        schoolVo.setName(bo.getName());
        schoolVo.setValue(bo.getValue());
        return schoolVo;
    }
}
