package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.UserLocationEntityExt;

public interface UserLocationEntityExtMapper {

    public int add(UserLocationEntityExt userLocationEntityExt);

    public void deleteById(int id);

    public void update(UserLocationEntityExt userLocationEntityExt);

    public List<UserLocationEntityExt> list(
            @Param("entity") UserLocationEntityExt userLocationEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") UserLocationEntityExt userLocationEntityExt);

    public List<UserLocationEntityExt> listAll();
    
    public int getCount();

    public UserLocationEntityExt getById(int id);
}
