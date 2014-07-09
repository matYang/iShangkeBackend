package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.AccountEntityExt;

public interface AccountEntityExtMapper {
    
    public int add(AccountEntityExt accountEntityExt);    
    public void deleteById(int id);
    public void update(AccountEntityExt accountEntityExt);
}