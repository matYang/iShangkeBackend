package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.AccountHistoryEntity;
import com.ishangke.edunav.dataaccess.model.gen.AccountHistoryEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountHistoryEntityMapper {
    int countByExample(AccountHistoryEntityExample example);

    int deleteByExample(AccountHistoryEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccountHistoryEntity record);

    int insertSelective(AccountHistoryEntity record);

    List<AccountHistoryEntity> selectByExample(AccountHistoryEntityExample example);

    AccountHistoryEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccountHistoryEntity record, @Param("example") AccountHistoryEntityExample example);

    int updateByExample(@Param("record") AccountHistoryEntity record, @Param("example") AccountHistoryEntityExample example);

    int updateByPrimaryKeySelective(AccountHistoryEntity record);

    int updateByPrimaryKey(AccountHistoryEntity record);
}