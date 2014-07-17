package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.AccountEntityExt;

public interface AccountEntityExtMapper {

    public int add(AccountEntityExt accountEntityExt);

    public void deleteById(int id);

    public void update(AccountEntityExt accountEntityExt);

    public int getCount();

    public List<AccountEntityExt> list(
            @Param("entity") AccountEntityExt accountEntityExt,
            @Param("page") PaginationEntity page);

    public List<AccountEntityExt> listAll();

    public AccountEntityExt getById(int id);

    public int getListCount(@Param("entity") AccountEntityExt accountEntityExt);
}