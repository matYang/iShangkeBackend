package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.LocationEntityExt;

public interface LocationEntityExtMapper {

    public int add(LocationEntityExt locationEntityExt);
    
    public void deleteById(int id);
    
    public void update(LocationEntityExt locationEntityExt);
    
    public int getCount();

    public List<LocationEntityExt> list(LocationEntityExt locationEntityExt);
}
