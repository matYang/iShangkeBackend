package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.AccountHistoryEntityExt;

public interface AccountHistoryEntityExtMapper {

    public int add(AccountHistoryEntityExt accountHistoryEntityExt);
    public void deleteById(int id);
    public void update(AccountHistoryEntityExt accountHistoryEntityExt);
}
