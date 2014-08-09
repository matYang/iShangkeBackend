package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.commoncontract.model.AccountPageViewBo;
import com.ishangke.edunav.web.converter.AccountConverter;
import com.ishangke.edunav.web.model.AccountVo;
import com.ishangke.edunav.web.model.pageview.AccountPageViewVo;

public class AccountPageViewConverter {
    public static AccountPageViewVo toModel(AccountPageViewBo bo) {
        AccountPageViewVo vo = new AccountPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<AccountVo> result = new ArrayList<>();
            for (AccountBo b : bo.getData()) {
                result.add(AccountConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
