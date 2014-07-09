package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.CourseCommentEntityExt;

public interface CourseCommentEntityExtMapper {

    public int add(CourseCommentEntityExt courseCommentEntityExt);
    public void deleteById(int id);
    public void update(CourseCommentEntityExt courseCommentEntityExt);
}
