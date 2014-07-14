package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.model.ApproveHistoryEntityExt;

public interface ApproveHistoryEntityExtMapper {

    public int add(ApproveHistoryEntityExt approveHistoryEntityExt);

    public void deleteById(int id);

    public void update(ApproveHistoryEntityExt approveHistoryEntityExt);

    public int getCount();

    public List<ApproveHistoryEntityExt> list(
            @Param("entity") ApproveHistoryEntityExt approveHistoryEntityExt,
            @Param("page") PaginationEntity page);

    public int getListCount(@Param("entity") ApproveHistoryEntityExt approveHistoryEntityExt);
}
