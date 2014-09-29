package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.GroupBuyActivityEntityExt;

public interface GroupBuyActivityEntityExtMapper {
    public int add(GroupBuyActivityEntityExt groupBuyActivityEntityExt);
    
    public void deleteById(int id);
    
    public List<GroupBuyActivityEntityExt> list(@Param("entity") GroupBuyActivityEntityExt groupBuyActivityEntityExt,@Param("page") PaginationEntity page);
    
    public int getListCount(@Param("entity") GroupBuyActivityEntityExt groupBuyActivityEntityExt);
    
    public void update(GroupBuyActivityEntityExt groupBuyActivityEntityExt);
    
    public GroupBuyActivityEntityExt getById(int id);
}
