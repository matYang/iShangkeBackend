package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CreditHistoryEntityExt;

public interface CreditHistoryEntityExtMapper {

    public int add(CreditHistoryEntityExt creditHistoryEntityExt);

    public void deleteById(int id);

    public void update(CreditHistoryEntityExt creditHistoryEntityExt);

    public int getCount();

    public List<CreditHistoryEntityExt> list(
            @Param("entity") CreditHistoryEntityExt creditHistoryEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") CreditHistoryEntityExt creditHistoryEntityExt);
}
