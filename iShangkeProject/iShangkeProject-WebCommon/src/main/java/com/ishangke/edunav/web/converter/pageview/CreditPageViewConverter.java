package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.CreditBo;
import com.ishangke.edunav.commoncontract.model.CreditPageViewBo;
import com.ishangke.edunav.web.converter.CreditConverter;
import com.ishangke.edunav.web.model.CreditVo;
import com.ishangke.edunav.web.model.pageview.CreditPageViewVo;

public class CreditPageViewConverter {
    public static CreditPageViewVo toModel(CreditPageViewBo bo) {
        CreditPageViewVo vo = new CreditPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<CreditVo> result = new ArrayList<>();
            for (CreditBo b : bo.getData()) {
                result.add(CreditConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
