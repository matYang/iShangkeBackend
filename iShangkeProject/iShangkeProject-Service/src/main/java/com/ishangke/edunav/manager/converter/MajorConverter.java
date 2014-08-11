package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.MajorBo;
import com.ishangke.edunav.dataaccess.model.MajorEntityExt;

public class MajorConverter {
    public static MajorBo toBo(MajorEntityExt e) {
        if (e == null) {
            return null;
        }
        MajorBo majorBo = new MajorBo();
        if (e.getEnabled() != null) {
            majorBo.setEnabled(e.getEnabled());
        }
        if (e.getId() != null) {
            majorBo.setId(e.getId());
        }
        if (e.getName() != null) {
            majorBo.setName(e.getName());
        }
        if (e.getValue() != null) {
            majorBo.setValue(e.getValue());
        }
        if (e.getSchoolId() != null) {
            majorBo.setSchoolId(e.getSchoolId());
        }
        majorBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        majorBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        return majorBo;
    }

    public static MajorEntityExt fromBo(MajorBo bo) {
        if (bo == null) {
            return null;
        }
        MajorEntityExt majorEntityExt = new MajorEntityExt();
        majorEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        majorEntityExt.setEnabled(bo.getEnabled());
        majorEntityExt.setId(bo.getId());
        majorEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        majorEntityExt.setName(bo.getName());
        majorEntityExt.setValue(bo.getValue());
        majorEntityExt.setSchoolId(bo.getSchoolId());
        return majorEntityExt;
    }
}
