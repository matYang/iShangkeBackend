package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.UserGroupEntityExt;

public interface UserGroupEntityExtMapper {

    public int add(UserGroupEntityExt userGroupEntityExt);
    
    public void deleteById(int id);
    
    public void update(UserGroupEntityExt userGroupEntityExt);
    
    public int getCount();

    public List<UserGroupEntityExt> list(@Param("entity") UserGroupEntityExt userGroupEntityExt, @Param("page") PaginationEntity page);
}
