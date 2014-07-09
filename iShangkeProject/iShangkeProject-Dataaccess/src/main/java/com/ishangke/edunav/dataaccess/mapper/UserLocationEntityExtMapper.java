package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.UserLocationEntityExt;

public interface UserLocationEntityExtMapper {

    public int add(UserLocationEntityExt userLocationEntityExt);
    public void deleteById(int id);
    public void update(UserLocationEntityExt userLocationEntityExt);
}
