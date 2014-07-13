package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.OrderEntity;
import com.ishangke.edunav.dataaccess.model.gen.OrderEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderEntityMapper {
    int countByExample(OrderEntityExample example);

    int deleteByExample(OrderEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderEntity record);

    int insertSelective(OrderEntity record);

    List<OrderEntity> selectByExample(OrderEntityExample example);

    OrderEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderEntity record, @Param("example") OrderEntityExample example);

    int updateByExample(@Param("record") OrderEntity record, @Param("example") OrderEntityExample example);

    int updateByPrimaryKeySelective(OrderEntity record);

    int updateByPrimaryKey(OrderEntity record);
}