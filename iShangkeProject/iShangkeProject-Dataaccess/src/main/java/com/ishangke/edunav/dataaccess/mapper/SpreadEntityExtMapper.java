package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.SpreadEntityExt;

public interface SpreadEntityExtMapper {

    public int add(SpreadEntityExt spreadEntityExt);
    
    public void deleteById(int id);
    
    public void update(SpreadEntityExt spreadEntityExt);
    
    public int getCount();

    public List<SpreadEntityExt> list(@Param("entity") SpreadEntityExt spreadEntityExt, @Param("page") PaginationEntity page);
}
