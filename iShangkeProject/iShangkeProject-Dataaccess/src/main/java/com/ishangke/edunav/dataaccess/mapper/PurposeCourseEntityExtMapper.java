package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.PurposeCourseEntityExt;

public interface PurposeCourseEntityExtMapper {
    public int add(PurposeCourseEntityExt purposeCourseEntityExt);

    public void deleteById(int id);

    public List<PurposeCourseEntityExt> list(@Param("entity") PurposeCourseEntityExt purposeCourseEntityExt, @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") PurposeCourseEntityExt purposeCourseEntityExt);

    public PurposeCourseEntityExt update(PurposeCourseEntityExt purposeCourseEntityExt);

    public PurposeCourseEntityExt getById(int id);
}