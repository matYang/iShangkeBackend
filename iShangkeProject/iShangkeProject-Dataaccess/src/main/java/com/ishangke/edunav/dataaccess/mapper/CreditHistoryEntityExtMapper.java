package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.CreditHistoryEntityExt;

public interface CreditHistoryEntityExtMapper {

    public int add(CreditHistoryEntityExt creditHistoryEntityExt);
    public void deleteById(int id);
    public void update(CreditHistoryEntityExt creditHistoryEntityExt);
}
