package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.CouponHistoryEntity;
import com.ishangke.edunav.dataaccess.model.gen.CouponHistoryEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponHistoryEntityMapper {
    int countByExample(CouponHistoryEntityExample example);

    int deleteByExample(CouponHistoryEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouponHistoryEntity record);

    int insertSelective(CouponHistoryEntity record);

    List<CouponHistoryEntity> selectByExample(CouponHistoryEntityExample example);

    CouponHistoryEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouponHistoryEntity record, @Param("example") CouponHistoryEntityExample example);

    int updateByExample(@Param("record") CouponHistoryEntity record, @Param("example") CouponHistoryEntityExample example);

    int updateByPrimaryKeySelective(CouponHistoryEntity record);

    int updateByPrimaryKey(CouponHistoryEntity record);
}