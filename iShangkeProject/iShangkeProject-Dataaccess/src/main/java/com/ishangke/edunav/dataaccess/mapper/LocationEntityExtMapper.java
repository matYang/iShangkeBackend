package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.LocationEntityExt;

public interface LocationEntityExtMapper {

    public int add(LocationEntityExt locationEntityExt);

    public void deleteById(int id);

    public void update(LocationEntityExt locationEntityExt);

    public List<LocationEntityExt> list(
            @Param("entity") LocationEntityExt locationEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") LocationEntityExt locationEntityExt);

    public List<LocationEntityExt> listAll();

    public int getCount();

    public LocationEntityExt getById(int id);

}
