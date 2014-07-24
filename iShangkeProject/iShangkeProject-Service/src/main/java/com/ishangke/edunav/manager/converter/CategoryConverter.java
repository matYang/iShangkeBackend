package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;

public class CategoryConverter {
    public static CategoryBo toBo(CategoryEntityExt e) {
        CategoryBo categoryBo = new CategoryBo();
        categoryBo.setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        categoryBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd().getTimeInMillis());
        categoryBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart().getTimeInMillis());
        categoryBo.setEnabled(e.getEnabled());
        categoryBo.setId(e.getId());
        categoryBo.setIdSet(e.getIdSet());
        categoryBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime().getTimeInMillis());
        categoryBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeEnd().getTimeInMillis());
        categoryBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e.getLastModifyTimeStart().getTimeInMillis());
        categoryBo.setName(e.getName());
        categoryBo.setRank(e.getRank());
        categoryBo.setRankEnd(e.getRankEnd());
        categoryBo.setRankSet(e.getRankSet());
        categoryBo.setRankStart(e.getRankStart());
        categoryBo.setValue(e.getValue());
        return categoryBo;
    }

    public static CategoryEntityExt fromBo(CategoryBo bo) {
        CategoryEntityExt categoryEntityExt = new CategoryEntityExt();
        categoryEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        categoryEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        categoryEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        categoryEntityExt.setEnabled(bo.getEnabled());
        categoryEntityExt.setId(bo.getId());
        categoryEntityExt.setIdSet(bo.getIdSet());
        categoryEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        categoryEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        categoryEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        categoryEntityExt.setName(bo.getName());
        categoryEntityExt.setRank(bo.getRank());
        categoryEntityExt.setRankEnd(bo.getRankEnd());
        categoryEntityExt.setRankSet(bo.getRankSet());
        categoryEntityExt.setRankStart(bo.getRankStart());
        categoryEntityExt.setValue(bo.getValue());
        return categoryEntityExt;
    }
}
