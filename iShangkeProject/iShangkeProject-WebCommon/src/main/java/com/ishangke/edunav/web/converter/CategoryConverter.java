package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.web.model.CategoryVo;

public class CategoryConverter {
    public static CategoryBo fromModel(CategoryVo vo) {
        CategoryBo categoryBo = new CategoryBo();
        if (vo.getEnabled() != null) {
            categoryBo.setEnabled(vo.getEnabled());
        }
        if (vo.getId() != null) {
            categoryBo.setId(vo.getId());
        }
        if (vo.getIdSet() != null) {
            categoryBo.setIdSet(vo.getIdSet());
        }
        if (vo.getName() != null) {
            categoryBo.setName(vo.getName());
        }
        if (vo.getRank() != null) {
            categoryBo.setRank(vo.getRank());
        }  else {
            categoryBo.setRank(Constant.DEFAULTNULL);
        }

        if (vo.getRankEnd() != null) {
            categoryBo.setRankEnd(vo.getRankEnd());
        }
        if (vo.getRankSet() != null) {
            categoryBo.setRankSet(vo.getRankSet());
        }
        if (vo.getRankStart() != null) {
            categoryBo.setRankStart(vo.getRankStart());
        }
        if (vo.getValue() != null) {
            categoryBo.setValue(vo.getValue());
        }
        categoryBo.setCreateTime(vo.getCreateTime() == null ? Constant.DEFAULTNULL : vo.getCreateTime().getTimeInMillis());
        categoryBo.setCreateTimeEnd(vo.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : vo.getCreateTimeEnd().getTimeInMillis());
        categoryBo.setCreateTimeStart(vo.getCreateTimeStart() == null ? Constant.DEFAULTNULL : vo.getCreateTimeStart().getTimeInMillis());
        categoryBo.setLastModifyTime(vo.getLastModifyTime() == null ? Constant.DEFAULTNULL : vo.getLastModifyTime().getTimeInMillis());
        categoryBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeEnd().getTimeInMillis());
        categoryBo.setLastModifyTimeStart(vo.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : vo.getLastModifyTimeStart().getTimeInMillis());
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
        if (Constant.DEFAULTNULL != bo.getRank()) {
        categoryVo.setRank(bo.getRank());
        }
        categoryVo.setRankEnd(bo.getRankEnd());
        categoryVo.setRankSet(bo.getRankSet());
        categoryVo.setRankStart(bo.getRankStart());
        categoryVo.setValue(bo.getValue());
        return categoryVo;
    }
}
