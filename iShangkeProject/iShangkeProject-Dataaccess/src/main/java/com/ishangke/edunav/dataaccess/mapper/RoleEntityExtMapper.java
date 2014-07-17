package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.RoleEntityExt;

public interface RoleEntityExtMapper {

    public int add(RoleEntityExt roleEntityExt);

    public void deleteById(int id);

    public void update(RoleEntityExt roleEntityExt);

    public List<RoleEntityExt> list(
            @Param("entity") RoleEntityExt roleEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") RoleEntityExt roleEntityExt);

    public List<RoleEntityExt> listAll();

    public int getCount();
    
    public List<RoleEntityExt> listRolesByUserId(int userId);
    
    public int getCountByUserId(int userId);
    
    public List<RoleEntityExt> listRoleByGroupId(int groupId);
    
    public int getCountByGroupId(int groupId);

    public RoleEntityExt getById(int id);
}
