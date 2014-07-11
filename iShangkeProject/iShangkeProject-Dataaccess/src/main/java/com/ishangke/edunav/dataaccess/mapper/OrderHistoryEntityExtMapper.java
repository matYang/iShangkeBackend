package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.OrderHistoryEntityExt;

public interface OrderHistoryEntityExtMapper {

    public int add(OrderHistoryEntityExt orderHistoryEntityExt);
    
    public void deleteById(int id);
    
    public void update(OrderHistoryEntityExt orderHistoryEntityExt);
    
    public int getCount();

    public List<OrderHistoryEntityExt> list(OrderHistoryEntityExt orderHistoryEntityExt);
}
