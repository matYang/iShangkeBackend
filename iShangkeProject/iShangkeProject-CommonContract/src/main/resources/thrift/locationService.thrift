include "fault.thrift"
include "common.thrift"
include "location.thrift"

namespace java com.ishangke.edunav.commoncontract.service 
service LocationService {
    /**
     *  本方法为查询location信息的功能<br>
     *  任意用户可以通过此方法查询所有location
     *
     *  @param  queryUser     需要检索和过滤的LocationBo信息
     *  @param  paginationBo  分页信息
     *
     *  @return Category实体 LocationBo 列表
     *
     */
    common.ResponseBo queryLocation(1: location.LocationBo locationBo, 2: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为查询location信息的功能<br>
     *  任意用户可以通过此方法查询所有location
     *
     *  @param  queryUser     需要检索和过滤的LocationBo信息
     *  @param  paginationBo  分页信息
     *
     *  @return Category实体 LocationBo 列表
     *
     */
    common.ResponseBo queryCircle(1: location.CircleBo circleBo, 2: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
}