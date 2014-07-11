package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.ApproveHistoryEntityExt;

public interface ApproveHistoryEntityExtMapper {

    public int add(ApproveHistoryEntityExt approveHistoryEntityExt);
    
    public void deleteById(int id);
    
    public void update(ApproveHistoryEntityExt approveHistoryEntityExt);
    
    public int getCount();

    public List<ApproveHistoryEntityExt> list(ApproveHistoryEntityExt approveHistoryEntityExt);
}
