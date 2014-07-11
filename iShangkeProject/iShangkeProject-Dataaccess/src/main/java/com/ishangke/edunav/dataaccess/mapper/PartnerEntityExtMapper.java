package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;

public interface PartnerEntityExtMapper {

    public int add(PartnerEntityExt partnerEntityExt);
    
    public void deleteById(int id);
    
    public void update(PartnerEntityExt partnerEntityExt);
    
    public int getCount();

    public List<PartnerEntityExt> list(PartnerEntityExt partnerEntityExt);
}
