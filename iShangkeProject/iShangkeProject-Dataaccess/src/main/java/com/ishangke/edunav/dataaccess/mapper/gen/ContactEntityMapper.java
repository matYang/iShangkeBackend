package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.ContactEntity;
import com.ishangke.edunav.dataaccess.model.gen.ContactEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContactEntityMapper {
    int countByExample(ContactEntityExample example);

    int deleteByExample(ContactEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ContactEntity record);

    int insertSelective(ContactEntity record);

    List<ContactEntity> selectByExample(ContactEntityExample example);

    ContactEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ContactEntity record, @Param("example") ContactEntityExample example);

    int updateByExample(@Param("record") ContactEntity record, @Param("example") ContactEntityExample example);

    int updateByPrimaryKeySelective(ContactEntity record);

    int updateByPrimaryKey(ContactEntity record);
}