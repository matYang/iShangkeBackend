package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.PurposeCourseBo;
import com.ishangke.edunav.dataaccess.model.PurposeCourseEntityExt;

public class PurposeCourseConverter {
    public static PurposeCourseBo toBo(PurposeCourseEntityExt e) {
        if (e == null) {
            return null;
        }
        PurposeCourseBo bo = new PurposeCourseBo();
        if (e.getCategoryId() != null) {
            bo.setCategoryId(e.getCategoryId());
        } else {
            bo.setCategoryId(Constant.DEFAULTNULL);
        }
        if (e.getId() != null) {
            bo.setId(e.getId());
        }
        if (e.getPhone() != null) {
            bo.setPhone(e.getPhone());
        }
        if (e.getRemark() != null) {
            bo.setRemark(e.getRemark());
        }
        if (e.getUserName() != null) {
            bo.setUserName(e.getUserName());
        }
        bo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        return bo;
    }
    
    public static PurposeCourseEntityExt fromBo(PurposeCourseBo bo) {
        if (bo == null) {
            return null;
        }
        PurposeCourseEntityExt e = new PurposeCourseEntityExt();
        if (bo.getCategoryId() != Constant.DEFAULTNULL) {
            e.setCategoryId(bo.getCategoryId());            
        }
        e.setId(bo.getId());
        e.setPhone(bo.getPhone());
        e.setRemark(bo.getRemark());
        e.setUserName(bo.getUserName());
        e.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        e.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        e.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        return e;
    }
}
