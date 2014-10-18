package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.CoursePromotionPhotoEntityExt;

public interface CoursePromotionPhotoEntityExtMapper {
    public int add(CoursePromotionPhotoEntityExt coursePromotionPhotoEntityExt);

    public void deleteById(int id);
    
    public int deleteByCoursePromotionActivityId(int id);

    public List<CoursePromotionPhotoEntityExt> list(@Param("entity") CoursePromotionPhotoEntityExt coursePromotionPhotoEntityExt,@Param("page") PaginationEntity page);
    
    public int getListCount(@Param("entity") CoursePromotionPhotoEntityExt coursePromotionPhotoEntityExt);
    
    public void update(CoursePromotionPhotoEntityExt coursePromotionPhotoEntityExt);
    
    public CoursePromotionPhotoEntityExt getById(int id);
}
