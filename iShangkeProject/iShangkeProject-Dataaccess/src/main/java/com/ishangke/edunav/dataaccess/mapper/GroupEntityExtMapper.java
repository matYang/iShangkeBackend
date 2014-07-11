package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.GroupEntityExt;

public interface GroupEntityExtMapper {

    public int add(GroupEntityExt groupEntityExt);
    
    public void deleteById(int id);
    
    public void update(GroupEntityExt groupEntityExt);
    
    public int getCount();

    public List<GroupEntityExt> list(GroupEntityExt groupEntityExt);
}
