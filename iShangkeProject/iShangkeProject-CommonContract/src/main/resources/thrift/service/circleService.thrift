include "model/fault.thrift"
include "model/common.thrift"
include "model/circle.thrift"

namespace java com.ishangke.edunav.commoncontract.service 
service CircleService {

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
    list<circle.CircleBo> query(1: circle.CircleBo circleBo, 2: common.PaginationBo paginationBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
}