package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.PermissionBo;
import com.ishangke.edunav.commoncontract.model.PermissionPageViewBo;
import com.ishangke.edunav.web.converter.PermissionConverter;
import com.ishangke.edunav.web.model.PermissionVo;
import com.ishangke.edunav.web.model.pageview.PermissionPageViewVo;

public class PermissionPageViewConverter {
    public static PermissionPageViewVo toModel(PermissionPageViewBo bo) {
        PermissionPageViewVo vo = new PermissionPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<PermissionVo> result = new ArrayList<>();
            for (PermissionBo b : bo.getData()) {
                result.add(PermissionConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
