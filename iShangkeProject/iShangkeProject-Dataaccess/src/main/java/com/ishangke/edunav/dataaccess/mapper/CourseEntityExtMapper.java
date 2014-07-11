package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;

public interface CourseEntityExtMapper {

    public int add(CourseEntityExt courseEntityExt);

    public void deleteById(int id);

    public void update(CourseEntityExt courseEntityExt);
    
    public int getCount();

    public List<CourseEntityExt> list(@Param("entity") CourseEntityExt courseEntityExt, @Param("page") PaginationEntity page);
}
