package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.PartnerEntity;
import com.ishangke.edunav.dataaccess.model.gen.PartnerEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PartnerEntityMapper {
    int countByExample(PartnerEntityExample example);

    int deleteByExample(PartnerEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PartnerEntity record);

    int insertSelective(PartnerEntity record);

    List<PartnerEntity> selectByExample(PartnerEntityExample example);

    PartnerEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PartnerEntity record, @Param("example") PartnerEntityExample example);

    int updateByExample(@Param("record") PartnerEntity record, @Param("example") PartnerEntityExample example);

    int updateByPrimaryKeySelective(PartnerEntity record);

    int updateByPrimaryKey(PartnerEntity record);
}