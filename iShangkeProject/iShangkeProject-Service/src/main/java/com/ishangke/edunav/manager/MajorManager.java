package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.MajorBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;

public interface MajorManager {
    /**
     * 本方法为查询location信息的功能<br>
     * 任意用户可以通过此方法查询所有location
     * 
     * @param queryUser
     *            需要检索和过滤的MajorBo信息
     * @param paginationBo
     *            分页信息
     * 
     * @return 实体 MajorBo 列表
     * 
     * 
     * @param locationBo
     * @param paginationBo
     */
    List<MajorBo> query(MajorBo majorBo, PaginationBo paginationBo);
}
