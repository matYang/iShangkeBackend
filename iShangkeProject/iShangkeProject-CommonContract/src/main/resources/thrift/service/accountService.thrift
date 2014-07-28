include "model/fault.thrift"
include "model/common.thrift"
include "model/user.thrift"
include "model/account.thrift"
include "model/accountHistory.thrift"
include "model/coupon.thrift"
include "model/couponHistory.thrift" 
include "model/credit.thrift"
include "model/creditHistory.thrift"
include "model/withdraw.thrift"
include "model/partner.thrift"
include "model/contact.thrift"


namespace java com.ishangke.edunav.commoncontract.service

service AccountService{


    /**********************************************************
    *
    *   关于账户相关的 Account
    *
    **********************************************************/

    /**
     *  本方法为账户提现功能。<br>
     *  用户可以将自己账户中的现金提现
     *
     *  @param  accountBo       需要提现的账户信息
     *  @param  userBo          调用方法的用户的信息
     *
     *  @return 
     *
     */ 
    account.AccountBo exchangeCash(1: account.AccountBo accountBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

	/**
     *  本方法为查询账户功能。<br>
     *  用户可以查询自己拥有的账户，系统可以查看所有账户
     *
     *  @param  accountBo       需要检索和过滤的账户信息
     *  @param  userBo          调用方法的用户的信息
     *  @param  paginationBo 	分页信息
     *
     *  @return AccountBo 列表
     *
     */ 
     account.AccountPageViewBo queryAccount(1: account.AccountBo accountBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

	/**
     *  本方法为查询账户历史功能。<br>
     *  用户可以查询自己拥有的账户的历史信息，系统可以查看所有账户的历史信息
     *
     *  @param  accountHistoryBo        需要检索和过滤的账户信息
     *  @param  userBo                  调用方法的用户的信息
     *  @param  paginationBo 	          分页信息
     *
     *  @return AccountHistoryBo 列表
     *
     */ 
     accountHistory.AccountHistoryPageViewBo queryAccountHistory(1: accountHistory.AccountHistoryBo accountHistoryBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)







    /**********************************************************
    *
    *   关于消费券 Coupon
    *
    **********************************************************/

    /**
     *  本方法为创建优惠券功能。<br>
     *  系统根据相关条件，创建优惠券
     *
     *  @param  couponBo       优惠券信息
     *  @param  userBo         调用方法的用户的信息
     *
     *  @return 优惠券实体 CouponBo 
     */
    coupon.CouponBo createCoupon(1: coupon.CouponBo couponBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

	/**
     *  本方法为激活优惠券功能。<br>
     *  用户优惠券
     *
     *  @param  couponBo       需要激活的优惠券信息
     *  @param  userBo         调用方法的用户的信息
     *
     *  @return 激活后的优惠券实体 CouponBo 
     */
    coupon.CouponBo activateCoupon(1: coupon.CouponBo couponBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	

    /**
     *  本方法为查询优惠券功能。<br>
     *  用户可以查询自己拥有的优惠券，系统可以查看所有优惠券
     *
     *  @param  couponBo        需要检索和过滤的优惠券
     *  @param  userBo          调用方法的用户的信息
     *  @param  paginationBo    分页信息
     *
     *  @return 优惠券实体 CouponBo 列表
     *
     */ 
    coupon.CouponPageViewBo queryCoupon(1: coupon.CouponBo couponBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为查询优惠券历史功能。<br>
     *  用户可以查询自己拥有的优惠券历史，系统可以查看所有优惠券历史
     *
     *  @param  couponHistoryBo 需要检索和过滤的优惠券历史
     *  @param  userBo          调用方法的用户的信息
     *  @param  paginationBo    分页信息
     *
     *  @return CouponHistoryBo 列表
     *
     */ 
    couponHistory.CouponHistoryPageViewBo queryCouponHistory(1: couponHistory.CouponHistoryBo couponHistoryBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)





    /**********************************************************
    *
    *   关于积分 Credit
    *
    **********************************************************/

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
    credit.CreditBo exchangeCoupon(1: credit.CreditBo creditBo, 2: coupon.CouponBo couponBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    credit.CreditBo exchangeAccount(1: credit.CreditBo creditBo, 2: account.AccountBo accountBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    credit.CreditPageViewBo queryCredit(1: credit.CreditBo creditBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

        /**
     *  本方法为查询积分历史功能。<br>
     *  用户可以查询自己的使用积分历史，系统可以查看所有积分历史
     *
     *  @param  creditHistoryBo         需要检索和过滤的积分信息历史
     *  @param  userBo                  调用方法的用户的信息
     *  @param  paginationBo            分页信息
     *
     *  @return 积分实体 CreditHistoryBo 列表
     *
     */ 
    creditHistory.CreditHistoryPageViewBo queryCreditHistory(1: creditHistory.CreditHistoryBo creditHistoryBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    





    /**********************************************************
    *
    *   关于取款方式 Withdraw
    *
    **********************************************************/

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
   withdraw.WithdrawPageViewBo queryWithdraw(1: withdraw.WithdrawBo withdrawBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
     







    /**********************************************************
    *
    *   关于常用上课人 Contact
    *
    **********************************************************/

     /**
     *  创建常用联系人信息。<br>
     *  用户可以创建常用联系人信息
     *
     *  @param  contactBo          需要创建的常用联系人信息
     *  @param  userBo             发起创建的用户信息
     *
     *  @return 创建完成的常用联系人信息
     *
     */
    contact.ContactBo createContact(1: contact.ContactBo contactBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  更新常用联系人信息。<br>
     *  用户可以更新常用联系人信息
     *
     *  @param  contactBo          需要更新的常用联系人信息
     *  @param  userBo             发起更新的用户信息
     *
     *  @return 更新完成的常用联系人信息
     *
     */
    contact.ContactBo updateContact(1: contact.ContactBo contactBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  删除常用联系人信息。<br>
     *  用户可以删除常用联系人信息
     *
     *  @param  contactBo          需要删除的常用联系人信息
     *  @param  userBo             发起删除的用户信息
     *
     *  @return 
     *
     */
    contact.ContactBo deleteContact(1: contact.ContactBo contactBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  查询常用联系人信息。<br>
     *  用户可以查询常用联系人信息
     *
     *  @param  contactBo          需要查询的常用联系人信息
     *  @param  userBo             发起查询的用户信息
     *  @param  paginationBo       分页信息
     *
     *  @return  Contact 列表
     *
     */
    contact.ContactPageViewBo queryContact(1: contact.ContactBo contactBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
     

}