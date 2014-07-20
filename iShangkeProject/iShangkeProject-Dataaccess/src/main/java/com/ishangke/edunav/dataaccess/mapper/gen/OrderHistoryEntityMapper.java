package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.OrderHistoryEntity;
import com.ishangke.edunav.dataaccess.model.gen.OrderHistoryEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderHistoryEntityMapper {
    int countByExample(OrderHistoryEntityExample example);

    int deleteByExample(OrderHistoryEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderHistoryEntity record);

    int insertSelective(OrderHistoryEntity record);

    List<OrderHistoryEntity> selectByExample(OrderHistoryEntityExample example);

    OrderHistoryEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderHistoryEntity record, @Param("example") OrderHistoryEntityExample example);

    int updateByExample(@Param("record") OrderHistoryEntity record, @Param("example") OrderHistoryEntityExample example);

    int updateByPrimaryKeySelective(OrderHistoryEntity record);

    int updateByPrimaryKey(OrderHistoryEntity record);
}