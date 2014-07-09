package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.CircleEntityExt;

public interface CircleEntityExtMapper {

    public int add(CircleEntityExt circleEntityExt);
    public void deleteById(int id);
    public void update(CircleEntityExt circleEntityExt);
}
