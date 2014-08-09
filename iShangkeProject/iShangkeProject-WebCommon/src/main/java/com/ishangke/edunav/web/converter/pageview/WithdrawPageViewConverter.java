package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.WithdrawBo;
import com.ishangke.edunav.commoncontract.model.WithdrawPageViewBo;
import com.ishangke.edunav.web.converter.WithdrawConverter;
import com.ishangke.edunav.web.model.WithdrawVo;
import com.ishangke.edunav.web.model.pageview.WithdrawPageViewVo;

public class WithdrawPageViewConverter {
    public static WithdrawPageViewVo toModel(WithdrawPageViewBo bo) {
        WithdrawPageViewVo vo = new WithdrawPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<WithdrawVo> result = new ArrayList<>();
            for (WithdrawBo b : bo.getData()) {
                result.add(WithdrawConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
