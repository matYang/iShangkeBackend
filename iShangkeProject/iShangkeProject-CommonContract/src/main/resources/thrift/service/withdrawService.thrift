include "model/fault.thrift"
include "model/common.thrift"
include "model/user.thrift"
include "model/withdraw.thrift"
include "model/partner.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service WithdrawService{

	/**
     *  创建存取款信息。<br>
     *  用户可以创建存取款信息
     *
     *  @param  withdrawBo         需要创建的存取款信息
     *  @param  userBo             发起创建的用户信息
     *
     *  @return 创建完成的存取款信息
     *
     */
    withdraw.WithdrawBo createWithdraw(1: withdraw.WithdrawBo withdrawBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  更新存取款信息。<br>
     *  用户可以更新存取款信息
     *
     *  @param  withdrawBo         需要更新的存取款信息
     *  @param  userBo             发起更新的用户信息
     *
     *  @return 更新完成的存取款信息
     *
     */
    withdraw.WithdrawBo updateWithdraw(1: withdraw.WithdrawBo withdrawBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  删除存取款信息。<br>
     *  用户可以删除存取款信息
     *
     *  @param  withdrawBo         需要删除的存取款信息
     *  @param  userBo             发起删除的用户信息
     *
     *  @return 
     *
     */
    withdraw.WithdrawBo deleteWithdraw(1: withdraw.WithdrawBo withdrawBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  查询存取款信息。<br>
     *  用户可以查询存取款信息
     *
     *  @param  withdrawBo         需要查询的存取款信息
     *  @param  userBo             发起查询的用户信息
     *  @param  paginationBo       分页信息
     *
     *  @return  Withdraw 列表
     *
     */
    list<withdraw.WithdrawBo> query(1: withdraw.WithdrawBo withdrawBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	
}