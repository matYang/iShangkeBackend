package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CoursePromotionEntityExt;

public interface CoursePromotionEntityExtMapper {
    public int add(CoursePromotionEntityExt coursePromotionEntityExt);
    
    public void deleteById(int id);
    
    public List<CoursePromotionEntityExt> listByCategoryId(@Param("categoryId") int categoryId, @Param("page") PaginationEntity page);
    
    public int getCountByCategoryId(int categortId);
}