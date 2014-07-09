package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.ActivityEntityExt;

public interface ActivityEntityExtMapper {
    public int add(ActivityEntityExt activityEntityExt);
    public void deleteById(int id);
    public void update(ActivityEntityExt activityEntityExt);
    
}
