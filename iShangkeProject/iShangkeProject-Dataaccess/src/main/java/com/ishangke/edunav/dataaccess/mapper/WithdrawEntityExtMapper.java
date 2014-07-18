package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.WithdrawEntityExt;

public interface WithdrawEntityExtMapper {

    public int add(WithdrawEntityExt withdrawEntityExt);

    public void deleteById(int id);

    public void update(WithdrawEntityExt withdrawEntityExt);

    public List<WithdrawEntityExt> list(@Param("entity") WithdrawEntityExt withdrawEntityExt, @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") WithdrawEntityExt withdrawEntityExt);

    public List<WithdrawEntityExt> listAll();

    public int getCount();

    public WithdrawEntityExt getById(int id);
}
