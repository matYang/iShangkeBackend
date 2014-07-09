package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.ApproveHistoryEntityExt;

public interface ApproveHistoryEntityExtMapper {

    public int add(ApproveHistoryEntityExt approveHistoryEntityExt);
    public void deleteById(int id);
    public void update(ApproveHistoryEntityExt approveHistoryEntityExt);
}
