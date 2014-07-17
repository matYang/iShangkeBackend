package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CircleEntityExt;

public interface CircleEntityExtMapper {

    public int add(CircleEntityExt circleEntityExt);

    public void deleteById(int id);

    public void update(CircleEntityExt circleEntityExt);

    public List<CircleEntityExt> list(
            @Param("entity") CircleEntityExt circleEntityExt,
            @Param("page") PaginationEntity page);
 
    public int getListCount(@Param("entity") CircleEntityExt circleEntityExt);

    public List<CircleEntityExt> listAll();

    public int getCount();

    public CircleEntityExt getById(int id);
}
