package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.AccountEntity;
import com.ishangke.edunav.dataaccess.model.gen.AccountEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountEntityMapper {
    int countByExample(AccountEntityExample example);

    int deleteByExample(AccountEntityExample example);

    int insert(AccountEntity record);

    int insertSelective(AccountEntity record);

    List<AccountEntity> selectByExample(AccountEntityExample example);

    int updateByExampleSelective(@Param("record") AccountEntity record, @Param("example") AccountEntityExample example);

    int updateByExample(@Param("record") AccountEntity record, @Param("example") AccountEntityExample example);
}