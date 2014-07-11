package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.AccountEntityExt;

public interface AccountEntityExtMapper {

    public int add(AccountEntityExt accountEntityExt);

    public void deleteById(int id);

    public void update(AccountEntityExt accountEntityExt);

    public int getCount();

    public List<AccountEntityExt> list(AccountEntityExt accountEntityExt);
}