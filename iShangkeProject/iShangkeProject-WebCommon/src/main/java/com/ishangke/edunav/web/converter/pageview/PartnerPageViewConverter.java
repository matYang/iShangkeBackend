package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.PartnerPageViewBo;
import com.ishangke.edunav.web.converter.PartnerConverter;
import com.ishangke.edunav.web.model.PartnerVo;
import com.ishangke.edunav.web.model.pageview.PartnerPageViewVo;

public class PartnerPageViewConverter {
    public static PartnerPageViewVo toModel(PartnerPageViewBo bo) {
        PartnerPageViewVo vo = new PartnerPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getStart());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<PartnerVo> result = new ArrayList<>();
            for (PartnerBo b : bo.getData()) {
                result.add(PartnerConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
