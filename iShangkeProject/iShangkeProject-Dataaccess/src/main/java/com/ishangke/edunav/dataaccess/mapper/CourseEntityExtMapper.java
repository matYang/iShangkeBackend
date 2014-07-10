package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.CourseEntityExt;

public interface CourseEntityExtMapper {

    public int add(CourseEntityExt courseEntityExt);

    public void deleteById(int id);

    public void update(CourseEntityExt courseEntityExt);

    public List<CourseEntityExt> list(CourseEntityExt courseEntityExt);
}
