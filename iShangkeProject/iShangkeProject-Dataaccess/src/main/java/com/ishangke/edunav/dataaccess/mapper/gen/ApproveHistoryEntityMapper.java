package com.ishangke.edunav.dataaccess.mapper.gen;

import com.ishangke.edunav.dataaccess.model.gen.ApproveHistoryEntity;
import com.ishangke.edunav.dataaccess.model.gen.ApproveHistoryEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApproveHistoryEntityMapper {
    int countByExample(ApproveHistoryEntityExample example);

    int deleteByExample(ApproveHistoryEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApproveHistoryEntity record);

    int insertSelective(ApproveHistoryEntity record);

    List<ApproveHistoryEntity> selectByExample(ApproveHistoryEntityExample example);

    ApproveHistoryEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApproveHistoryEntity record, @Param("example") ApproveHistoryEntityExample example);

    int updateByExample(@Param("record") ApproveHistoryEntity record, @Param("example") ApproveHistoryEntityExample example);

    int updateByPrimaryKeySelective(ApproveHistoryEntity record);

    int updateByPrimaryKey(ApproveHistoryEntity record);
}