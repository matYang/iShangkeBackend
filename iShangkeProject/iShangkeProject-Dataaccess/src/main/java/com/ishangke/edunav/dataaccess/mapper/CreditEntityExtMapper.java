package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.CreditEntityExt;

public interface CreditEntityExtMapper {

    public int add(CreditEntityExt creditEntityExt);
    
    public void deleteById(int id);
    
    public void update(CreditEntityExt creditEntityExt);
    
    public int getCount();

    public List<CreditEntityExt> list(CreditEntityExt creditEntityExt);
}
