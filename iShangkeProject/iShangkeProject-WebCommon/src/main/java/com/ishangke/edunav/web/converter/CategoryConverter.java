package com.ishangke.edunav.web.converter;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.web.model.CategoryVo;

public class CategoryConverter {
    public static CategoryBo fromModel(CategoryVo vo) {
        if (vo == null) {
            return null;
        }
        CategoryBo categoryBo = new CategoryBo();
        if (vo.getEnabled() != null) {
            categoryBo.setEnabled(vo.getEnabled());
        } else {
            categoryBo.setEnabled(Constant.DEFAULTNULL);
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
        } else {
            categoryBo.setRank(Constant.DEFAULTNULL);
        }

        if (vo.getRankEnd() != null) {
            categoryBo.setRankEnd(vo.getRankEnd());
        } else {
            categoryBo.setRankEnd(Constant.DEFAULTNULL);
        }
        if (vo.getRankSet() != null) {
            categoryBo.setRankSet(vo.getRankSet());
        }
        if (vo.getRankStart() != null) {
            categoryBo.setRankStart(vo.getRankStart());
        } else {
            categoryBo.setRankStart(Constant.DEFAULTNULL);
        }
        if (vo.getValue() != null) {
            categoryBo.setValue(vo.getValue());
        }
        if (vo.getCreateTime() != null) {
            categoryBo.setCreateTime(vo.getCreateTime());
        } else {
            categoryBo.setCreateTime(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeEnd() != null) {
            categoryBo.setCreateTimeEnd(vo.getCreateTimeEnd());
        } else {
            categoryBo.setCreateTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getCreateTimeStart() != null) {
            categoryBo.setCreateTimeStart(vo.getCreateTimeStart());
        } else {
            categoryBo.setCreateTimeStart(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTime() != null) {
            categoryBo.setLastModifyTime(vo.getLastModifyTime());
        } else {
            categoryBo.setLastModifyTime(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeEnd() != null) {
            categoryBo.setLastModifyTimeEnd(vo.getLastModifyTimeEnd());
        } else {
            categoryBo.setLastModifyTimeEnd(Constant.DEFAULTNULL);
        }
        if (vo.getLastModifyTimeStart() != null) {
            categoryBo.setLastModifyTimeStart(vo.getLastModifyTimeStart());
        } else {
            categoryBo.setLastModifyTimeStart(Constant.DEFAULTNULL);
        }
        return categoryBo;
    }

    public static CategoryVo toModel(CategoryBo bo) {
        if (bo == null) {
            return null;
        }
        CategoryVo categoryVo = new CategoryVo();
        //categoryVo.setCreateTime(bo.getCreateTime());
        //categoryVo.setCreateTimeEnd(bo.getCreateTimeEnd());
        //categoryVo.setCreateTimeStart(bo.getCreateTimeStart());
        if (bo.getEnabled() != Constant.DEFAULTNULL) {
            categoryVo.setEnabled(bo.getEnabled());            
        }
        categoryVo.setId(bo.getId());
        categoryVo.setIdSet(bo.getIdSet());
        //categoryVo.setLastModifyTime(bo.getLastModifyTime());
        //categoryVo.setLastModifyTimeEnd(bo.getLastModifyTimeEnd());
        //categoryVo.setLastModifyTimeStart(bo.getLastModifyTimeStart());
        categoryVo.setName(bo.getName());
        if (Constant.DEFAULTNULL != bo.getRank()) {
            categoryVo.setRank(bo.getRank());
        }
        if (Constant.DEFAULTNULL != bo.getRankEnd()) {
            categoryVo.setRankEnd(bo.getRankEnd());
        }
        categoryVo.setRankSet(bo.getRankSet());
        if (Constant.DEFAULTNULL != bo.getRankStart()) {
            categoryVo.setRankStart(bo.getRankStart());
        }
        categoryVo.setValue(bo.getValue());
        return categoryVo;
    }
}
