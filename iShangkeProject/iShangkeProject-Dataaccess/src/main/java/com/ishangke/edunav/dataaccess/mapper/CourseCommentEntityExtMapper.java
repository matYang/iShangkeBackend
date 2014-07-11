package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CourseCommentEntityExt;

public interface CourseCommentEntityExtMapper {

    public int add(CourseCommentEntityExt courseCommentEntityExt);
    
    public void deleteById(int id);
    
    public void update(CourseCommentEntityExt courseCommentEntityExt);
    
    public int getCount();

    public List<CourseCommentEntityExt> list(@Param("entity")CourseCommentEntityExt courseCommentEntityExt, @Param("page") PaginationEntity page);
}

