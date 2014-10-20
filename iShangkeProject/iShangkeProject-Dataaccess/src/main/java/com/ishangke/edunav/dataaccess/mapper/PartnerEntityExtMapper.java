package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;

public interface PartnerEntityExtMapper {

    public int add(PartnerEntityExt partnerEntityExt);

    public void deleteById(int id);

    public void update(PartnerEntityExt partnerEntityExt);

    public List<PartnerEntityExt> list(
            @Param("entity") PartnerEntityExt partnerEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") PartnerEntityExt partnerEntityExt);

    public List<PartnerEntityExt> listAll();

    public int getCount();

    public PartnerEntityExt getById(int id);
    
    public PartnerEntityExt getInfoById(int id);
    
    public List<PartnerEntityExt> getIdSet(
            @Param("entity") PartnerEntityExt partnerEntityExt,
            @Param("page") PaginationEntity page,
            @Param("type") String type,
            @Param("order") String order);
    
    public List<PartnerEntityExt> listByIdSet(@Param("idSet") Set<Integer> idSet);
}
