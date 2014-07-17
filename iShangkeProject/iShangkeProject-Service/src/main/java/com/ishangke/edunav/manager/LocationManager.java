package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.BusinessExceptionBo;
import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;

public interface LocationManager {
    /**
     * 本方法为查询location信息的功能<br>
     * 任意用户可以通过此方法查询所有location
     * 
     * @param queryUser
     *            需要检索和过滤的LocationBo信息
     * @param paginationBo
     *            分页信息
     * 
     * @return Category实体 LocationBo 列表
     * 
     * 
     * @param locationBo
     * @param paginationBo
     */
    public List<LocationBo> query(LocationBo locationBo, PaginationBo paginationBo) throws BusinessExceptionBo, org.apache.thrift.TException;

}
