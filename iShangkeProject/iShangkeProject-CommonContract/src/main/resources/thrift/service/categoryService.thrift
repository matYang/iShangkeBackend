include "model/fault.thrift"
include "model/common.thrift"
include "model/category.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service CategoryService {
    /**
     *  本方法为查询category信息的功能<br>
     *  任意用户可以通过此方法查询所有Category
     *
     *  @param  queryUser     需要检索和过滤的CategoryBo信息
     *  @param  paginationBo  分页信息
     *
     *  @return Category实体 CategoryBo 列表
     *
     */
    list<category.CategoryBo> query(1: category.CategoryBo categoryBo, 2: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

}