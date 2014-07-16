package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.ApproveHistoryBo;
import com.ishangke.edunav.dataaccess.model.ApproveHistoryEntityExt;

public class ApproveHistoryConverter {
    public static ApproveHistoryBo toBo(ApproveHistoryEntityExt e) {
        return new ApproveHistoryBo();
    }

    public static ApproveHistoryEntityExt fromBo(ApproveHistoryBo bo) {
        return new ApproveHistoryEntityExt();
    }
}
