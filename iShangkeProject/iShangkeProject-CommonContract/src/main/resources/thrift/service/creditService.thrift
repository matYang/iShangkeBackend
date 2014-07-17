include "model/fault.thrift"
include "model/common.thrift"
include "model/user.thrift"
include "model/account.thrift"
include "model/credit.thrift"
include "model/creditHistory.thrift"
include "model/coupon.thrift"


namespace java com.ishangke.edunav.commoncontract.service

service CreditService{
	/**
     *  本方法为换取优惠券。<br>
     *  用户可以将自己的积分换取优惠券
     *
     *  @param  creditBo        积分信息
     *  @param  couponBo        优惠券信息
     *  @param  userBo          调用方法的用户的信息
     *
     *  @return 
     *
     */ 
    credit.CreditBo exchangeCoupon(1: credit.CreditBo creditBo, 2: coupon.CouponBo couponBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为换取现金。<br>
     *  用户可以将自己的积分换取现金
     *
     *  @param  creditBo        积分信息
     *  @param  accountBo       账户信息信息
     *  @param  userBo          调用方法的用户的信息
     *
     *  @return 
     *
     */ 
    credit.CreditBo exchangeAccount(1: credit.CreditBo creditBo, 2: account.AccountBo accountBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为查询积分功能。<br>
     *  用户可以查询自己拥有的积分，系统可以查看所有积分
     *
     *  @param  creditBo        需要检索和过滤的积分信息
     *  @param  userBo          调用方法的用户的信息
     *  @param  paginationBo    分页信息
     *
     *  @return 积分实体 CreditBo 列表
     *
     */ 
    list<credit.CreditBo> query(1: credit.CreditBo creditBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

        /**
     *  本方法为查询积分历史功能。<br>
     *  用户可以查询自己的使用积分历史，系统可以查看所有积分历史
     *
     *  @param  creditHistoryBo         需要检索和过滤的积分信息历史
     *  @param  userBo                  调用方法的用户的信息
     *  @param  paginationBo            分页信息
     *
     *  @return 积分实体 CreditBo 列表
     *
     */ 
    list<credit.CreditBo> queryHistory(1: creditHistory.CreditHistoryBo creditHistoryBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
}