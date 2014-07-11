package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.CircleEntityExt;

public interface CircleEntityExtMapper {

    public int add(CircleEntityExt circleEntityExt);
    
    public void deleteById(int id);
    
    public void update(CircleEntityExt circleEntityExt);
    
    public int getCount();

    public List<CircleEntityExt> list(CircleEntityExt circleEntityExt);
}
