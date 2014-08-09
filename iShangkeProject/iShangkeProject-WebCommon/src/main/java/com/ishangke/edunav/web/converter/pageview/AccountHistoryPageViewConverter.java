package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
import com.ishangke.edunav.commoncontract.model.AccountHistoryPageViewBo;
import com.ishangke.edunav.web.converter.AccountHistoryConverter;
import com.ishangke.edunav.web.model.AccountHistoryVo;
import com.ishangke.edunav.web.model.pageview.AccountHistoryPageViewVo;

public class AccountHistoryPageViewConverter {
    public static AccountHistoryPageViewVo toModel(AccountHistoryPageViewBo bo) {
        AccountHistoryPageViewVo vo = new AccountHistoryPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<AccountHistoryVo> result = new ArrayList<>();
            for (AccountHistoryBo b : bo.getData()) {
                result.add(AccountHistoryConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
