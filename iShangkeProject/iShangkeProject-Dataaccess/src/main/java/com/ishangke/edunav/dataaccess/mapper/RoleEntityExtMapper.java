package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.RoleEntityExt;

public interface RoleEntityExtMapper {

    public int add(RoleEntityExt roleEntityExt);

    public void deleteById(int id);

    public void update(RoleEntityExt roleEntityExt);

    public int getCount();

    public List<RoleEntityExt> list(
            @Param("entity") RoleEntityExt roleEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") RoleEntityExt roleEntityExt,
            @Param("page") PaginationEntity page);
}
