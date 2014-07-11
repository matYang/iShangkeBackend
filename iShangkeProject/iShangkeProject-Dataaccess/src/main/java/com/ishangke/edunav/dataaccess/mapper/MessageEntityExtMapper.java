package com.ishangke.edunav.dataaccess.mapper;

import java.util.List;

import com.ishangke.edunav.dataaccess.model.MessageEntityExt;

public interface MessageEntityExtMapper {

    public int add(MessageEntityExt messageEntityExt);
    
    public void deleteById(int id);
    
    public void update(MessageEntityExt messageEntityExt);
    
    public int getCount();

    public List<MessageEntityExt> list(MessageEntityExt messageEntityExt);
}
