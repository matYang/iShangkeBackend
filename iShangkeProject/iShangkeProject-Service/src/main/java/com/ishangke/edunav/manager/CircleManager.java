package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;

public interface CircleManager {
    /**
     *  本方法为查询circle信息的功能<br>
     *  任意用户可以通过此方法查询所有circle
     *
     *  @param  queryUser     需要检索和过滤的circleBo信息
     *  @param  paginationBo  分页信息
     *
     *  @return Category实体 circleBo 列表
     *
     */
    List<CircleBo> queryCircle(CircleBo circleBo, PaginationBo paginationBo);
}
