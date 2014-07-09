package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;

public interface PartnerEntityExtMapper {

    public int add(PartnerEntityExt partnerEntityExt);
    public void deleteById(int id);
    public void update(PartnerEntityExt partnerEntityExt);
}
