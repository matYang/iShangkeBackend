package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.ApproveHistoryBo;
import com.ishangke.edunav.web.user.model.ApproveHistoryVo;

public class ApproveHistoryConverter {
    public static ApproveHistoryBo fromModel(ApproveHistoryVo e) {
        ApproveHistoryBo approveHistoryBo = new ApproveHistoryBo();
        return approveHistoryBo;
    }

    public static ApproveHistoryVo toModel(ApproveHistoryBo bo) {
        ApproveHistoryVo approveHistoryVo = new ApproveHistoryVo();
        return approveHistoryVo;
    }
}
