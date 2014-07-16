include "model/fault.thrift"
include "model/common.thrift"
include "model/user.thrift"
include "model/coupon.thrift" 

namespace java com.ishangke.edunav.commoncontract.service

service CouponService{

	 /**
     *  本方法为创建优惠券功能。<br>
     *  系统根据相关条件，创建优惠券
     *
     *  @param  couponBo       优惠券信息
     *  @param  userBo         调用方法的用户的信息
     *
     *  @return 优惠券实体 CouponBo 
     */
    common.ResponseBo generateCoupon(1: coupon.CouponBo couponBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    common.ResponseBo query(1: coupon.CouponBo couponBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

}