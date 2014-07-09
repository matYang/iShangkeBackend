package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;

public interface ClassPhotoEntityExtMapper {

    public int add(ClassPhotoEntityExt classphotoEntityExt);
    public void deleteById(int id);
    public void update(ClassPhotoEntityExt classphotoEntityExt);
}
