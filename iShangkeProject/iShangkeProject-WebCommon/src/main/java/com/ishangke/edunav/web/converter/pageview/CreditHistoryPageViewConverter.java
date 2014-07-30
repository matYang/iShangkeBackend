package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.CreditHistoryBo;
import com.ishangke.edunav.commoncontract.model.CreditHistoryPageViewBo;
import com.ishangke.edunav.web.converter.CreditHistoryConverter;
import com.ishangke.edunav.web.model.CreditHistoryVo;
import com.ishangke.edunav.web.model.pageview.CreditHistoryPageViewVo;

public class CreditHistoryPageViewConverter {
    public static CreditHistoryPageViewVo toModel(CreditHistoryPageViewBo bo) {
        CreditHistoryPageViewVo vo = new CreditHistoryPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<CreditHistoryVo> result = new ArrayList<>();
            for (CreditHistoryBo b : bo.getData()) {
                result.add(CreditHistoryConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
