package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.CreditEntityExt;

public interface CreditEntityExtMapper {

    public int add(CreditEntityExt creditEntityExt);
    public void deleteById(int id);
    public void update(CreditEntityExt creditEntityExt);
}
