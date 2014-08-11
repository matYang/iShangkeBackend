package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.MajorBo;
import com.ishangke.edunav.web.model.MajorVo;

public class MajorConverter {
    public static MajorBo fromModel(MajorVo vo) {
        if (vo == null) {
            return null;
        }
        MajorBo majorBo = new MajorBo();
        if (vo.getEnabled() != null) {
            majorBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            majorBo.setId(vo.getId());
        }
        if (vo.getSchoolId() != null) {
            majorBo.setSchoolId(vo.getSchoolId());
        }
        if (vo.getName() != null) {
            majorBo.setName(vo.getName());
        }
        if (vo.getValue() != null) {
            majorBo.setValue(vo.getValue());
        }
        if (vo.getCreateTime() != null) {
            majorBo.setCreateTime(vo.getCreateTime());
        } else {
            majorBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            majorBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            majorBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        return majorBo;
    }

    public static MajorVo toModel(MajorBo bo) {
        if (bo == null) {
            return null;
        }
        MajorVo majorVo = new MajorVo();
        majorVo.setCreateTime(bo.getCreateTime());
        majorVo.setEnabled(bo.getEnabled());
        majorVo.setId(bo.getId());
        majorVo.setSchoolId(bo.getSchoolId());
        majorVo.setLastModifyTime(bo.getLastModifyTime());
        majorVo.setName(bo.getName());
        majorVo.setValue(bo.getValue());
        return majorVo;
    }
}
