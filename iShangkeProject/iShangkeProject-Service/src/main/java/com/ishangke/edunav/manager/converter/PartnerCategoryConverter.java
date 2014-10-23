package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.commoncontract.model.PartnerCategoryBo;
import com.ishangke.edunav.dataaccess.model.PartnerCategoryEntityExt;

public class PartnerCategoryConverter {
    public static PartnerCategoryBo toBo(PartnerCategoryEntityExt e) {
        if (e == null) {
            return null;
        }
        PartnerCategoryBo partnerCategoryBo = new PartnerCategoryBo();
        if (e.getPartnerId() != null) {
            partnerCategoryBo.setPartnerId(e.getPartnerId());
        }
        if (e.getId() != null) {
            partnerCategoryBo.setId(e.getId());
        }
        if (e.getCategoryId() != null) {
            partnerCategoryBo.setCategoryId(e.getCategoryId());
        }
        return partnerCategoryBo;
    }

    public static PartnerCategoryEntityExt fromBo(PartnerCategoryBo bo) {
        if (bo == null) {
            return null;
        }
        PartnerCategoryEntityExt partnerCategoryEntityExt = new PartnerCategoryEntityExt();
        partnerCategoryEntityExt.setPartnerId(bo.getPartnerId());
        partnerCategoryEntityExt.setId(bo.getId());
        partnerCategoryEntityExt.setCategoryId(bo.getCategoryId());
        return partnerCategoryEntityExt;
    }
}
