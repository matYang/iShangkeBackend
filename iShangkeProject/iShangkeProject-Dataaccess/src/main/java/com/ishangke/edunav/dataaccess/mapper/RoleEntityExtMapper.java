package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.RoleEntityExt;

public interface RoleEntityExtMapper {

    public int add(RoleEntityExt roleEntityExt);
    public void deleteById(int id);
    public void update(RoleEntityExt roleEntityExt);
}
