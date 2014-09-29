package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.GroupBuyAddressEntityExt;

public interface GroupBuyAddressEntityExtMapper {
    public int add(GroupBuyAddressEntityExt groupBuyAddressEntityExt);
    
    public void deleteById(int id);
    
    public int deleteByGroupBuyActivityId(int id);

    public List<GroupBuyAddressEntityExt> list(@Param("entity") GroupBuyAddressEntityExt groupBuyAddressEntityExt,@Param("page") PaginationEntity page);
    
    public int getListCount(@Param("entity") GroupBuyAddressEntityExt groupBuyAddressEntityExt);
    
    public void update(GroupBuyAddressEntityExt groupBuyAddressEntityExt);
    
    public GroupBuyAddressEntityExt getById(int id);
}
