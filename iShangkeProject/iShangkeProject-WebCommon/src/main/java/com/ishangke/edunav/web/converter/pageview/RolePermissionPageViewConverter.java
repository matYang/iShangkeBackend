package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.RolePermissionBo;
import com.ishangke.edunav.commoncontract.model.RolePermissionPageViewBo;
import com.ishangke.edunav.web.converter.RolePermissionConverter;
import com.ishangke.edunav.web.model.RolePermissionVo;
import com.ishangke.edunav.web.model.pageview.RolePermissionPageViewVo;

public class RolePermissionPageViewConverter {
    public static RolePermissionPageViewVo toModel(RolePermissionPageViewBo bo) {
        RolePermissionPageViewVo vo = new RolePermissionPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<RolePermissionVo> result = new ArrayList<>();
            for (RolePermissionBo b : bo.getData()) {
                result.add(RolePermissionConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
