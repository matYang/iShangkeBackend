package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;

public interface GroupEntityExtMapper {

    public int add(GroupEntityExt groupEntityExt);

    public void deleteById(int id);

    public void update(GroupEntityExt groupEntityExt);

    public List<GroupEntityExt> list(
            @Param("entity") GroupEntityExt groupEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") GroupEntityExt groupEntityExt);

    public List<GroupEntityExt> listAll();

    public int getCount();
    
    public List<GroupEntityExt> listGroupsByUserId(int userId);
    
    public int getCountByUserId(int userId);

    public GroupEntityExt getById(int id);

}
