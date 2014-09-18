package com.ishangke.edunav.manager.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.dataaccess.model.CategoryEntityExt;

public class CategoryConverter {
    public static CategoryBo toBo(CategoryEntityExt e) {
        if (e == null) {
            return null;
        }
        CategoryBo categoryBo = new CategoryBo();
        if (e.getEnabled() != null) {
            categoryBo.setEnabled(e.getEnabled());
        } else {
            categoryBo.setEnabled(Constant.DEFAULTNULL);
        }
        if (e.getId() != null) {
            categoryBo.setId(e.getId());
        }
        if (e.getIdSet() != null) {
            categoryBo.setIdSet(e.getIdSet());
        }
        if (e.getName() != null) {
            categoryBo.setName(e.getName());
        }
        if (e.getRank() != null) {
            categoryBo.setRank(e.getRank());
        } else {
            categoryBo.setRank(Constant.DEFAULTNULL);
        }
        if (e.getRankEnd() != null) {
            categoryBo.setRankEnd(e.getRankEnd());
        } else {
            categoryBo.setRankEnd(Constant.DEFAULTNULL);
        }
        if (e.getRankSet() != null) {
            categoryBo.setRankSet(e.getRankSet());
        }
        if (e.getRankStart() != null) {
            categoryBo.setRankStart(e.getRankStart());
        } else {
            categoryBo.setRankStart(Constant.DEFAULTNULL);
        }
        if (e.getValue() != null) {
            categoryBo.setValue(e.getValue());
        }
        categoryBo
                .setCreateTime(e.getCreateTime() == null ? Constant.DEFAULTNULL : e.getCreateTime().getTimeInMillis());
        categoryBo.setCreateTimeEnd(e.getCreateTimeEnd() == null ? Constant.DEFAULTNULL : e.getCreateTimeEnd()
                .getTimeInMillis());
        categoryBo.setCreateTimeStart(e.getCreateTimeStart() == null ? Constant.DEFAULTNULL : e.getCreateTimeStart()
                .getTimeInMillis());
        categoryBo.setLastModifyTime(e.getLastModifyTime() == null ? Constant.DEFAULTNULL : e.getLastModifyTime()
                .getTimeInMillis());
        categoryBo.setLastModifyTimeEnd(e.getLastModifyTimeEnd() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeEnd().getTimeInMillis());
        categoryBo.setLastModifyTimeStart(e.getLastModifyTimeStart() == null ? Constant.DEFAULTNULL : e
                .getLastModifyTimeStart().getTimeInMillis());
        return categoryBo;
    }

    public static CategoryEntityExt fromBo(CategoryBo bo) {
        if (bo == null) {
            return null;
        }
        CategoryEntityExt categoryEntityExt = new CategoryEntityExt();
        categoryEntityExt.setCreateTime(DateUtility.getTimeFromLong(bo.getCreateTime()));
        categoryEntityExt.setCreateTimeEnd(DateUtility.getTimeFromLong(bo.getCreateTimeEnd()));
        categoryEntityExt.setCreateTimeStart(DateUtility.getTimeFromLong(bo.getCreateTimeStart()));
        if (bo.getEnabled() != Constant.DEFAULTNULL) {
            categoryEntityExt.setEnabled(bo.getEnabled());            
        }
        categoryEntityExt.setId(bo.getId());
        categoryEntityExt.setIdSet(bo.getIdSet());
        categoryEntityExt.setLastModifyTime(DateUtility.getTimeFromLong(bo.getLastModifyTime()));
        categoryEntityExt.setLastModifyTimeEnd(DateUtility.getTimeFromLong(bo.getLastModifyTimeEnd()));
        categoryEntityExt.setLastModifyTimeStart(DateUtility.getTimeFromLong(bo.getLastModifyTimeStart()));
        categoryEntityExt.setName(bo.getName());
        if (bo.getRank() != Constant.DEFAULTNULL) {
            categoryEntityExt.setRank(bo.getRank());
        }
        if (bo.getRankEnd() != Constant.DEFAULTNULL) {
            categoryEntityExt.setRankEnd(bo.getRankEnd());
        }
        categoryEntityExt.setRankSet(bo.getRankSet());
        if (bo.getRankStart() != Constant.DEFAULTNULL) {
            categoryEntityExt.setRankStart(bo.getRankStart());
        }
        categoryEntityExt.setValue(bo.getValue());
        return categoryEntityExt;
    }
}
