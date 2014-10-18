package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.PartnerCategoryEntityExt;

public interface PartnerCategoryEntityExtMapper {
    public int add(PartnerCategoryEntityExt partnerCategoryEntityExt);

    public void deleteById(int id);

    public void update(PartnerCategoryEntityExt partnerCategoryEntityExt);

    public List<PartnerCategoryEntityExt> list(
            @Param("entity") PartnerCategoryEntityExt partnerCategoryEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") PartnerCategoryEntityExt partnerCategoryEntityExt);

    public List<PartnerCategoryEntityExt> listAll();

    public int getCount();

    public PartnerCategoryEntityExt getById(int id);

    public void deleteByPartnerIdCategoryId(@Param("partnerId") int partnerId, @Param("categoryId") int categoryId);
}
