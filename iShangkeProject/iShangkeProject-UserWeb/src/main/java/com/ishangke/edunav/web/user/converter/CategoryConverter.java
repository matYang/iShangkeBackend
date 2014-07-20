package com.ishangke.edunav.web.user.converter;

import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.web.user.model.CategoryVo;
import com.ishangke.edunav.web.user.common.DateUtility;

public class CategoryConverter {
    public static CategoryBo fromModel(CategoryVo vo) {
        CategoryBo categoryBo = new CategoryBo();
        categoryBo.setCreateTime(vo.getCreateTime().getTimeInMillis());
        categoryBo.setCreateTimeEnd(vo.getCreateTimeEnd().getTimeInMillis());
        categoryBo.setCreateTimeStart(vo.getCreateTimeStart().getTimeInMillis());
        categoryBo.setEnabled(vo.getEnabled());
        categoryBo.setId(vo.getId());
        categoryBo.setIdSet(vo.getIdSet());
        categoryBo.setLastModifyTime(vo.getLastModifyTime().getTimeInMillis());
        categoryBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd().getTimeInMillis());
        categoryBo.setLastModifyTimeStart(vo.getLastModifyTimeStart().getTimeInMillis());
        categoryBo.setName(vo.getName());
        categoryBo.setRank(vo.getRank());
        categoryBo.setRankEnd(vo.getRankEnd());
        categoryBo.setRankSet(vo.getRankSet());
        categoryBo.setRankStart(vo.getRankStart());
        categoryBo.setValue(vo.getValue());
        return categoryBo;
    }

    public static CategoryVo toModel(CategoryBo bo) {
        CategoryVo categoryVo = new CategoryVo();
        categoryVo.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        categoryVo.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        categoryVo.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        categoryVo.setEnabled(bo.getEnabled());
        categoryVo.setId(bo.getId());
        categoryVo.setIdSet(bo.getIdSet());
        categoryVo.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        categoryVo.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        categoryVo.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        categoryVo.setName(bo.getName());
        categoryVo.setRank(bo.getRank());
        categoryVo.setRankEnd(bo.getRankEnd());
        categoryVo.setRankSet(bo.getRankSet());
        categoryVo.setRankStart(bo.getRankStart());
        categoryVo.setValue(bo.getValue());
        return categoryVo;
    }
}
