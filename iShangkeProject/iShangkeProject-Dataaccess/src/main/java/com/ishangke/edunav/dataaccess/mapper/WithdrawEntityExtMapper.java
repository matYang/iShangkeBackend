package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.WithdrawEntityExt;

public interface WithdrawEntityExtMapper {

    public int add(WithdrawEntityExt widthdrawEntityExt);
    public void deleteById(int id);
    public void update(WithdrawEntityExt widthdrawEntityExt);
}
