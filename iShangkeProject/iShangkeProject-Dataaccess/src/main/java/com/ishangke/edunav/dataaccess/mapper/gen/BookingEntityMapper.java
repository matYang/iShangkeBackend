package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.BookingEntity;
import com.ishangke.edunav.dataaccess.model.gen.BookingEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookingEntityMapper {
    int countByExample(BookingEntityExample example);

    int deleteByExample(BookingEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookingEntity record);

    int insertSelective(BookingEntity record);

    List<BookingEntity> selectByExample(BookingEntityExample example);

    BookingEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookingEntity record, @Param("example") BookingEntityExample example);

    int updateByExample(@Param("record") BookingEntity record, @Param("example") BookingEntityExample example);

    int updateByPrimaryKeySelective(BookingEntity record);

    int updateByPrimaryKey(BookingEntity record);
}