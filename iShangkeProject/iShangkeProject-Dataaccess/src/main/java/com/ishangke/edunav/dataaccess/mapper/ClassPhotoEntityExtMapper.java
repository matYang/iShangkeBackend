package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;

public interface ClassPhotoEntityExtMapper {

    public int add(ClassPhotoEntityExt classphotoEntityExt);
    
    public void deleteById(int id);
    
    public void update(ClassPhotoEntityExt classphotoEntityExt);
    
    public int getCount();

    public List<ClassPhotoEntityExt> list(ClassPhotoEntityExt classphotoEntityExt);
}
