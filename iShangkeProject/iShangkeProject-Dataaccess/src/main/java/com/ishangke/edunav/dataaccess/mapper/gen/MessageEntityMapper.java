package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.MessageEntity;
import com.ishangke.edunav.dataaccess.model.gen.MessageEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageEntityMapper {
    int countByExample(MessageEntityExample example);

    int deleteByExample(MessageEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MessageEntity record);

    int insertSelective(MessageEntity record);

    List<MessageEntity> selectByExample(MessageEntityExample example);

    MessageEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MessageEntity record, @Param("example") MessageEntityExample example);

    int updateByExample(@Param("record") MessageEntity record, @Param("example") MessageEntityExample example);

    int updateByPrimaryKeySelective(MessageEntity record);

    int updateByPrimaryKey(MessageEntity record);
}