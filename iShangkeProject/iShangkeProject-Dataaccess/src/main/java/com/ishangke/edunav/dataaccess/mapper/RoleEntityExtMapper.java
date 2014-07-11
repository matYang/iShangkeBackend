package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.RoleEntityExt;

public interface RoleEntityExtMapper {

    public int add(RoleEntityExt roleEntityExt);
    
    public void deleteById(int id);
    
    public void update(RoleEntityExt roleEntityExt);
    
    public int getCount();

    public List<RoleEntityExt> list(RoleEntityExt roleEntityExt);
}
