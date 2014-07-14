package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CreditEntityExt;

public interface CreditEntityExtMapper {

    public int add(CreditEntityExt creditEntityExt);

    public void deleteById(int id);

    public void update(CreditEntityExt creditEntityExt);

    public int getCount();

    public List<CreditEntityExt> list(
            @Param("entity") CreditEntityExt creditEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") CreditEntityExt creditEntityExt);
}
