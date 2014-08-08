package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;

public interface UserEntityExtMapper {

    public int add(UserEntityExt userEntityExt);

    public void deleteById(int id);

    public void update(UserEntityExt userEntityExt);

    public List<UserEntityExt> list(
            @Param("entity") UserEntityExt userEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") UserEntityExt userEntityExt);

    public List<UserEntityExt> listAll();

    public int getCount();

    public UserEntityExt getById(int id);
    
    public UserEntityExt getSimpleById(int id);
    
    public UserEntityExt getByInvitationCode(@Param("entity") UserEntityExt userEntityExt);
    
    public UserEntityExt getByPhone(@Param("entity") UserEntityExt userEntityExt);
    
    public UserEntityExt getByReference(@Param("entity") UserEntityExt userEntityExt);
}
