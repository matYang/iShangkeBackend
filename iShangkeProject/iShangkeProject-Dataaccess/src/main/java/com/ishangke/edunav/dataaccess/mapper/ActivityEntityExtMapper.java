package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.ActivityEntityExt;

public interface ActivityEntityExtMapper {
    public int add(ActivityEntityExt activityEntityExt);

    public void deleteById(int id);

    public void update(ActivityEntityExt activityEntityExt);

    public int getCount();

    public List<ActivityEntityExt> list(
            @Param("entity") ActivityEntityExt activityEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") ActivityEntityExt activityEntityExt);
}
