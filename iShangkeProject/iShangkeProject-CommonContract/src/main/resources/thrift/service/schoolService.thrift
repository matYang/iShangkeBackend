include "model/fault.thrift"
include "model/common.thrift"
include "model/school.thrift"

namespace java com.ishangke.edunav.commoncontract.service 
service SchoolService {

    /**
     *  本方法为查询school信息的功能<br>
     *  任意用户可以通过此方法查询所有school
     *
     *  @param  queryUser     需要检索和过滤的schoolBo信息
     *  @param  paginationBo  分页信息
     *
     *  @return Category实体 schoolBo 列表
     *
     */
    list<school.SchoolBo> query(1: school.SchoolBo schoolBo, 2: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
}