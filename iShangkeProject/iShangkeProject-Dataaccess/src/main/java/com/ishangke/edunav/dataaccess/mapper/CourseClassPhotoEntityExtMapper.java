package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.CourseClassPhotoEntityExt;

public interface CourseClassPhotoEntityExtMapper {

    public int add(CourseClassPhotoEntityExt courseClassPhotoEntityExt);
    public void deleteById(int id);
    public void update(CourseClassPhotoEntityExt courseClassPhotoEntityExt);
}
