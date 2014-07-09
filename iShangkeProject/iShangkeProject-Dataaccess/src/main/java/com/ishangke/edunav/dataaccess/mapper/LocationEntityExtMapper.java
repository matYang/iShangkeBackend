package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.LocationEntityExt;

public interface LocationEntityExtMapper {

    public int add(LocationEntityExt locationEntityExt);
    public void deleteById(int id);
    public void update(LocationEntityExt locationEntityExt);
}
