package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.WithdrawEntityExt;

public interface WithdrawEntityExtMapper {

    public int add(WithdrawEntityExt widthdrawEntityExt);
    
    public void deleteById(int id);
    
    public void update(WithdrawEntityExt widthdrawEntityExt);
    
    public int getCount();

    public List<WithdrawEntityExt> list(WithdrawEntityExt widthdrawEntityExt);
}
