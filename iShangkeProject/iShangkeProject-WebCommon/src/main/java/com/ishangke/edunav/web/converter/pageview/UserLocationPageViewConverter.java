package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.UserLocationBo;
import com.ishangke.edunav.commoncontract.model.UserLocationPageViewBo;
import com.ishangke.edunav.web.converter.UserLocationConverter;
import com.ishangke.edunav.web.model.UserLocationVo;
import com.ishangke.edunav.web.model.pageview.UserLocationPageViewVo;

public class UserLocationPageViewConverter {
    public static UserLocationPageViewVo toModel(UserLocationPageViewBo bo) {
        UserLocationPageViewVo vo = new UserLocationPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<UserLocationVo> result = new ArrayList<>();
            for (UserLocationBo b : bo.getData()) {
                result.add(UserLocationConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
