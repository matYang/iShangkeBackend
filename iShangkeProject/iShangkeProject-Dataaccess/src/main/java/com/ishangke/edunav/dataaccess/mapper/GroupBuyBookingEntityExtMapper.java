package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.GroupBuyBookingEntityExt;

public interface GroupBuyBookingEntityExtMapper {
public int add(GroupBuyBookingEntityExt groupBuyBookingEntityExt);
    
    public void deleteById(int id);
    
    public List<GroupBuyBookingEntityExt> list(@Param("entity") GroupBuyBookingEntityExt groupBuyBookingEntityExt,@Param("page") PaginationEntity page);
    
    public int getListCount(@Param("entity") GroupBuyBookingEntityExt groupBuyBookingEntityExt);
    
    public void update(GroupBuyBookingEntityExt groupBuyBookingEntityExt);
    
    public GroupBuyBookingEntityExt getById(int id);
}
