include "model/fault.thrift"
include "model/common.thrift"
include "model/career.thrift"

namespace java com.ishangke.edunav.commoncontract.service 
service CareerService {

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
    list<career.CareerBo> query(1: career.CareerBo careerBo, 2: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
}