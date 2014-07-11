package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.CourseClassPhotoEntityExt;

public interface CourseClassPhotoEntityExtMapper {

    public int add(CourseClassPhotoEntityExt courseClassPhotoEntityExt);
    
    public void deleteById(int id);
    
    public void update(CourseClassPhotoEntityExt courseClassPhotoEntityExt);
    
    public int getCount();

    public List<CourseClassPhotoEntityExt> list(CourseClassPhotoEntityExt courseClassPhotoEntityExt);
}
