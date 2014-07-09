package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.SpreadEntityExt;

public interface SpreadEntityExtMapper {

    public int add(SpreadEntityExt spreadEntityExt);
    public void deleteById(int id);
    public void update(SpreadEntityExt spreadEntityExt);
}
