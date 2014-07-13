package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.CreditEntity;
import com.ishangke.edunav.dataaccess.model.gen.CreditEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditEntityMapper {
    int countByExample(CreditEntityExample example);

    int deleteByExample(CreditEntityExample example);

    int insert(CreditEntity record);

    int insertSelective(CreditEntity record);

    List<CreditEntity> selectByExample(CreditEntityExample example);

    int updateByExampleSelective(@Param("record") CreditEntity record, @Param("example") CreditEntityExample example);

    int updateByExample(@Param("record") CreditEntity record, @Param("example") CreditEntityExample example);
}