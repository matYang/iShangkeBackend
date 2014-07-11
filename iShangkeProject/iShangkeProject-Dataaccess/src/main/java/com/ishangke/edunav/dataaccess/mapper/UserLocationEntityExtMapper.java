package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.UserLocationEntityExt;

public interface UserLocationEntityExtMapper {

    public int add(UserLocationEntityExt userLocationEntityExt);
    
    public void deleteById(int id);
    
    public void update(UserLocationEntityExt userLocationEntityExt);
    
    public int getCount();

    public List<UserLocationEntityExt> list(UserLocationEntityExt userLocationEntityExt);
}
