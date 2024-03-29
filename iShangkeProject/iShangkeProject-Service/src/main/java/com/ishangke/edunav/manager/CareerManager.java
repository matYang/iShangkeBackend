package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.CareerBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;

public interface CareerManager {
    /**
     *  本方法为查询career信息的功能<br>
     *  任意用户可以通过此方法查询所有career
     *
     *  @param  queryUser     需要检索和过滤的careerBo信息
     *  @param  paginationBo  分页信息
     *
     *  @return Category实体 careerBo 列表
     *
     */
    List<CareerBo> query(CareerBo careerBo,PaginationBo paginationBo);
}
