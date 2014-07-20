package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.WithdrawEntity;
import com.ishangke.edunav.dataaccess.model.gen.WithdrawEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WithdrawEntityMapper {
    int countByExample(WithdrawEntityExample example);

    int deleteByExample(WithdrawEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WithdrawEntity record);

    int insertSelective(WithdrawEntity record);

    List<WithdrawEntity> selectByExample(WithdrawEntityExample example);

    WithdrawEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WithdrawEntity record, @Param("example") WithdrawEntityExample example);

    int updateByExample(@Param("record") WithdrawEntity record, @Param("example") WithdrawEntityExample example);

    int updateByPrimaryKeySelective(WithdrawEntity record);

    int updateByPrimaryKey(WithdrawEntity record);
}