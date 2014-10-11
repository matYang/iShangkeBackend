package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.GroupBuyPhotoEntityExt;

public interface GroupBuyPhotoEntityExtMapper {
    public int add(GroupBuyPhotoEntityExt groupBuyPhotoEntityExt);
    
    // public void addBatch(@Param("entityList") List<GroupBuyPhotoEntityExt>
    // groupBuyPhotoEntityList);

    public void deleteById(int id);
    
    public int deleteByGroupBuyActivityId(int id);

    public List<GroupBuyPhotoEntityExt> list(@Param("entity") GroupBuyPhotoEntityExt groupBuyPhotoEntityExt,@Param("page") PaginationEntity page);
    
    public int getListCount(@Param("entity") GroupBuyPhotoEntityExt groupBuyPhotoEntityExt);
    
    public void update(GroupBuyPhotoEntityExt groupBuyPhotoEntityExt);
    
    public GroupBuyPhotoEntityExt getById(int id);
}
