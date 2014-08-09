package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.RoleBo;
import com.ishangke.edunav.commoncontract.model.RolePageViewBo;
import com.ishangke.edunav.web.converter.RoleConverter;
import com.ishangke.edunav.web.model.RoleVo;
import com.ishangke.edunav.web.model.pageview.RolePageViewVo;

public class RolePageViewConverter {
    public static RolePageViewVo toModel(RolePageViewBo bo) {
        RolePageViewVo vo = new RolePageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<RoleVo> result = new ArrayList<>();
            for (RoleBo b : bo.getData()) {
                result.add(RoleConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
