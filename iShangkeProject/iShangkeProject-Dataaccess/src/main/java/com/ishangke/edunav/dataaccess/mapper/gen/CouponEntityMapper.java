package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.CouponEntity;
import com.ishangke.edunav.dataaccess.model.gen.CouponEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponEntityMapper {
    int countByExample(CouponEntityExample example);

    int deleteByExample(CouponEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouponEntity record);

    int insertSelective(CouponEntity record);

    List<CouponEntity> selectByExample(CouponEntityExample example);

    CouponEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouponEntity record, @Param("example") CouponEntityExample example);

    int updateByExample(@Param("record") CouponEntity record, @Param("example") CouponEntityExample example);

    int updateByPrimaryKeySelective(CouponEntity record);

    int updateByPrimaryKey(CouponEntity record);
}