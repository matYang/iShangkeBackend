package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.GroupEntityExt;

public interface GroupEntityExtMapper {

    public int add(GroupEntityExt groupEntityExt);
    public void deleteById(int id);
    public void update(GroupEntityExt groupEntityExt);
}
