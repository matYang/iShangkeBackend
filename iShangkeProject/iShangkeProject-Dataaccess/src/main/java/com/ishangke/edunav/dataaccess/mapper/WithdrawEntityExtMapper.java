package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.WithdrawEntityExt;

public interface WithdrawEntityExtMapper {

    public int add(WithdrawEntityExt widthdrawEntityExt);

    public void deleteById(int id);

    public void update(WithdrawEntityExt widthdrawEntityExt);

    public int getCount();

    public List<WithdrawEntityExt> list(
            @Param("entity") WithdrawEntityExt widthdrawEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") WithdrawEntityExt widthdrawEntityExt);
}
