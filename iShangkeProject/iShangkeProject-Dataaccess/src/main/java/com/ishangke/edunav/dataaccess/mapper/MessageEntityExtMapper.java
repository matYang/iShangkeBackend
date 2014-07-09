package com.ishangke.edunav.dataaccess.mapper;

import com.ishangke.edunav.dataaccess.model.MessageEntityExt;

public interface MessageEntityExtMapper {

    public int add(MessageEntityExt messageEntityExt);
    public void deleteById(int id);
    public void update(MessageEntityExt messageEntityExt);
}
