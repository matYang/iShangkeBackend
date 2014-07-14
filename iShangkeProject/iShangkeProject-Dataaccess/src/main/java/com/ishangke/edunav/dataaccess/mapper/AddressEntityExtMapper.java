package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.AddressEntityExt;

public interface AddressEntityExtMapper {

    public int add(AddressEntityExt addressEntityExt);

    public void deleteById(int id);

    public void update(AddressEntityExt addressEntityExt);

    public int getCount();

    public List<AddressEntityExt> list(
            @Param("entity") AddressEntityExt addressEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") AddressEntityExt addressEntityExt);
}
