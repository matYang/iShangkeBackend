package com.ishangke.edunav.web.admin.converter;

import com.ishangke.edunav.commoncontract.model.ApproveHistoryBo;
import com.ishangke.edunav.dataaccess.model.ApproveHistoryEntityExt;

public class ApproveHistoryConverter {
    public static ApproveHistoryBo toBo(ApproveHistoryEntityExt e) {
        ApproveHistoryBo approveHistoryBo = new ApproveHistoryBo();
        return approveHistoryBo;
    }

    public static ApproveHistoryEntityExt fromBo(ApproveHistoryBo bo) {
        ApproveHistoryEntityExt approveHistoryEntityExt = new ApproveHistoryEntityExt();
        return approveHistoryEntityExt;
    }
}
