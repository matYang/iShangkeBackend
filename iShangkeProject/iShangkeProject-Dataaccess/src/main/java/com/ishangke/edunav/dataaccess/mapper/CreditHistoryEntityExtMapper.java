package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.CreditHistoryEntityExt;

public interface CreditHistoryEntityExtMapper {

    public int add(CreditHistoryEntityExt creditHistoryEntityExt);
    
    public void deleteById(int id);
    
    public void update(CreditHistoryEntityExt creditHistoryEntityExt);
    
    public int getCount();

    public List<CreditHistoryEntityExt> list(CreditHistoryEntityExt creditHistoryEntityExt);
}
