package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.UserGroupEntityExt;

public interface UserGroupEntityExtMapper {

    public int add(UserGroupEntityExt userGroupEntityExt);
    public void deleteById(int id);
    public void update(UserGroupEntityExt userGroupEntityExt);
}
