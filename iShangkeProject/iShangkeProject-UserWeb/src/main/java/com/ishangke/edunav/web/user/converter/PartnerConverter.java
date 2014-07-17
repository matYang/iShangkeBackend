package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;

public class PartnerConverter {
    public static PartnerBo toBo(PartnerEntityExt e) {
        PartnerBo partnerBo = new PartnerBo();
        return partnerBo;
    }

    public static PartnerEntityExt fromBo(PartnerBo bo) {
        PartnerEntityExt partnerEntityExt = new PartnerEntityExt();
        return partnerEntityExt;
    }
}
