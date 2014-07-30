package com.ishangke.edunav.web.converter.pageview;

import java.util.ArrayList;
import java.util.List;

import com.ishangke.edunav.commoncontract.model.ApproveHistoryBo;
import com.ishangke.edunav.commoncontract.model.ApproveHistoryPageViewBo;
import com.ishangke.edunav.web.converter.ApproveHistoryConverter;
import com.ishangke.edunav.web.model.ApproveHistoryVo;
import com.ishangke.edunav.web.model.pageview.ApproveHistoryPageViewVo;

public class ApproveHistoryPageViewConverter {
    public static ApproveHistoryPageViewVo toModel(ApproveHistoryPageViewBo bo) {
        ApproveHistoryPageViewVo vo = new ApproveHistoryPageViewVo();
        vo.setCount(bo.getCount());
        vo.setStart(bo.getCount());
        vo.setTotal(bo.getTotal());
        if (bo.getData() != null) {
            List<ApproveHistoryVo> result = new ArrayList<>();
            for (ApproveHistoryBo b : bo.getData()) {
                result.add(ApproveHistoryConverter.toModel(b));
            }
            vo.setData(result);
        }
        return vo;
    }
}
