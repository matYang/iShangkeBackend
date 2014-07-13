package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.CreditHistoryEntity;
import com.ishangke.edunav.dataaccess.model.gen.CreditHistoryEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditHistoryEntityMapper {
    int countByExample(CreditHistoryEntityExample example);

    int deleteByExample(CreditHistoryEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CreditHistoryEntity record);

    int insertSelective(CreditHistoryEntity record);

    List<CreditHistoryEntity> selectByExample(CreditHistoryEntityExample example);

    CreditHistoryEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CreditHistoryEntity record, @Param("example") CreditHistoryEntityExample example);

    int updateByExample(@Param("record") CreditHistoryEntity record, @Param("example") CreditHistoryEntityExample example);

    int updateByPrimaryKeySelective(CreditHistoryEntity record);

    int updateByPrimaryKey(CreditHistoryEntity record);
}