package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.GroupBo;

public interface GroupManager {
    List<GroupBo> listGroupsByUserId(int userId);
}
