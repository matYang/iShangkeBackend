package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.UserEntityExt;

public interface UserEntityExtMapper {

    public int add(UserEntityExt userEntityExt);
    public void deleteById(int id);
    public void update(UserEntityExt userEntityExt);
}
