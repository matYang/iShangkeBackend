include "fault.thrift"
include "common.thrift"
include "user.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service UserService {
  /**
   *  本方法为普通用户提供注册的功能。<br>
   *  用户可以通过此方法进行注册。
   *  @param  userBo    用户注册信息
   *  @return 用户实体 UserBo
   */
  common.ResponseBo registerUser(1: user.UserBo userBo, 2: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
}

