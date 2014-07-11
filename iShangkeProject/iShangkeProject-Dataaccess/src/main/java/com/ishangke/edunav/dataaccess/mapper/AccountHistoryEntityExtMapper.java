package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;
import com.ishangke.edunav.dataaccess.model.AccountHistoryEntityExt;

public interface AccountHistoryEntityExtMapper {

    public int add(AccountHistoryEntityExt accountHistoryEntityExt);
    
    public void deleteById(int id);
    
    public void update(AccountHistoryEntityExt accountHistoryEntityExt);
    
    public int getCount();

    public List<AccountHistoryEntityExt> list(AccountHistoryEntityExt accountHistoryEntityExt);
}
