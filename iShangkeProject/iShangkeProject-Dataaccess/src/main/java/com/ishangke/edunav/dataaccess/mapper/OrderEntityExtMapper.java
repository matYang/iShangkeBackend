package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.OrderEntityExt;

public interface OrderEntityExtMapper {

    public int add(OrderEntityExt orderEntityExt);

    public void deleteById(int id);

    public void update(OrderEntityExt orderEntityExt);

    public List<OrderEntityExt> list(
            @Param("entity") OrderEntityExt orderEntityExt,
            @Param("page") PaginationEntity page);
    
    public int getListCount(@Param("entity") OrderEntityExt orderEntityExt);

    public List<OrderEntityExt> listAll();

    public int getCount();

    public OrderEntityExt getById(int id);

}
