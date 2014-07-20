package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.BookingHistoryEntity;
import com.ishangke.edunav.dataaccess.model.gen.BookingHistoryEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookingHistoryEntityMapper {
    int countByExample(BookingHistoryEntityExample example);

    int deleteByExample(BookingHistoryEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookingHistoryEntity record);

    int insertSelective(BookingHistoryEntity record);

    List<BookingHistoryEntity> selectByExample(BookingHistoryEntityExample example);

    BookingHistoryEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookingHistoryEntity record, @Param("example") BookingHistoryEntityExample example);

    int updateByExample(@Param("record") BookingHistoryEntity record, @Param("example") BookingHistoryEntityExample example);

    int updateByPrimaryKeySelective(BookingHistoryEntity record);

    int updateByPrimaryKey(BookingHistoryEntity record);
}