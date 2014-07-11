package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.OrderEntityExt;

public interface OrderEntityExtMapper {

    public int add(OrderEntityExt orderEntityExt);
    
    public void deleteById(int id);
    
    public void update(OrderEntityExt orderEntityExt);
    
    public int getCount();

    public List<OrderEntityExt> list(OrderEntityExt orderEntityExt);
}
