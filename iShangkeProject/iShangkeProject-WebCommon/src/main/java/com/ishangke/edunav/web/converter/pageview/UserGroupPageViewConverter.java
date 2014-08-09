package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.UserGroupBo;
import com.ishangke.edunav.commoncontract.model.UserGroupPageViewBo;
import com.ishangke.edunav.web.converter.UserGroupConverter;
import com.ishangke.edunav.web.model.UserGroupVo;
import com.ishangke.edunav.web.model.pageview.UserGroupPageViewVo;

public class UserGroupPageViewConverter {
    public static UserGroupPageViewVo toModel(UserGroupPageViewBo bo) {
        UserGroupPageViewVo vo = new UserGroupPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<UserGroupVo> result = new ArrayList<>();
            for (UserGroupBo b : bo.getData()) {
                result.add(UserGroupConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
