package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.UserPageViewBo;
import com.ishangke.edunav.web.converter.UserConverter;
import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.model.pageview.UserPageViewVo;

public class UserPageViewConverter {
    public static UserPageViewVo toModel(UserPageViewBo bo) {
        UserPageViewVo vo = new UserPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<UserVo> result = new ArrayList<>();
            for (UserBo b : bo.getData()) {
                result.add(UserConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
