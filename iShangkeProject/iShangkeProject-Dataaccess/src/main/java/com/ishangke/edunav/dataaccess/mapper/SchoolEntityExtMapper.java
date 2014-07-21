package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.SchoolEntityExt;

public interface SchoolEntityExtMapper {

    public int add(SchoolEntityExt SchoolEntityExt);

    public void deleteById(int id);

    public void update(SchoolEntityExt SchoolEntityExt);

    public List<SchoolEntityExt> list(
            @Param("entity") SchoolEntityExt SchoolEntityExt,
            @Param("page") PaginationEntity page);
 
    public int getListCount(@Param("entity") SchoolEntityExt SchoolEntityExt);

    public List<SchoolEntityExt> listAll();

    public int getCount();

    public SchoolEntityExt getById(int id);
}
