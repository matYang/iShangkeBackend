package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.OrderHistoryEntityExt;

public interface OrderHistoryEntityExtMapper {

    public int add(OrderHistoryEntityExt orderHistoryEntityExt);

    public void deleteById(int id);

    public void update(OrderHistoryEntityExt orderHistoryEntityExt);

    public List<OrderHistoryEntityExt> list(
            @Param("entity") OrderHistoryEntityExt orderHistoryEntityExt,
            @Param("page") PaginationEntity page);
    
    public int getListCount(@Param("entity") OrderHistoryEntityExt orderHistoryEntityExt);

    public List<OrderHistoryEntityExt> listAll();

    public int getCount();

    public OrderHistoryEntityExt getById(int id);

}
