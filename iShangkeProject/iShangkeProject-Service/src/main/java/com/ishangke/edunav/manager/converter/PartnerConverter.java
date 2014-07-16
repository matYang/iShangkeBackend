package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;

public class PartnerConverter {
    public static PartnerBo toBo(PartnerEntityExt e) {
        return new PartnerBo();
    }

    public static PartnerEntityExt fromBo(PartnerBo bo) {
        return new PartnerEntityExt();
    }
}
