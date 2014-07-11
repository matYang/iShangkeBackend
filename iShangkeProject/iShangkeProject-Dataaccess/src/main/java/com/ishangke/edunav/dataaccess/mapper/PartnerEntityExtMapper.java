package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;

public interface PartnerEntityExtMapper {

    public int add(PartnerEntityExt partnerEntityExt);

    public void deleteById(int id);

    public void update(PartnerEntityExt partnerEntityExt);

    public int getCount();

    public List<PartnerEntityExt> list(
            @Param("entity") PartnerEntityExt partnerEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") PartnerEntityExt partnerEntityExt,
            @Param("page") PaginationEntity page);
}
