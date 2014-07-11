package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.MessageEntityExt;

public interface MessageEntityExtMapper {

    public int add(MessageEntityExt messageEntityExt);
    
    public void deleteById(int id);
    
    public void update(MessageEntityExt messageEntityExt);
    
    public int getCount();

    public List<MessageEntityExt> list(@Param("entity") MessageEntityExt messageEntityExt, @Param("page") PaginationEntity page);
}
