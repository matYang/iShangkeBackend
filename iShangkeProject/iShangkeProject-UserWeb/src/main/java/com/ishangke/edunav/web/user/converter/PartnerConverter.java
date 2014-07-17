package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.web.user.model.PartnerVo;

public class PartnerConverter {
    public static PartnerBo fromModel(PartnerVo e) {
        PartnerBo partnerBo = new PartnerBo();
        return partnerBo;
    }

    public static PartnerVo toModel(PartnerBo bo) {
        PartnerVo partnerVo = new PartnerVo();
        return partnerVo;
    }
}
