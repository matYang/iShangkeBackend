package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.AccountHistoryEntityExt;

public interface AccountHistoryEntityExtMapper {

    public int add(AccountHistoryEntityExt accountHistoryEntityExt);

    public void deleteById(int id);

    public void update(AccountHistoryEntityExt accountHistoryEntityExt);

    public List<AccountHistoryEntityExt> list(
            @Param("entity") AccountHistoryEntityExt accountHistoryEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") AccountHistoryEntityExt accountHistoryEntityExt);

    public List<AccountHistoryEntityExt> listAll();

    public int getCount();

    public AccountHistoryEntityExt getById(int id);
}
