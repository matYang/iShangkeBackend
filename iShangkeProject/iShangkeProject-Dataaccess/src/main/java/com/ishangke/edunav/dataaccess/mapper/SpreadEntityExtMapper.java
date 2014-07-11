package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.SpreadEntityExt;

public interface SpreadEntityExtMapper {

    public int add(SpreadEntityExt spreadEntityExt);
    
    public void deleteById(int id);
    
    public void update(SpreadEntityExt spreadEntityExt);
    
    public int getCount();

    public List<SpreadEntityExt> list(SpreadEntityExt spreadEntityExt);
}
