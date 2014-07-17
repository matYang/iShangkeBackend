package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.commoncontract.model.CouponHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface CouponManager {

	/**
     *  本方法为创建优惠券功能。<br>
     *  系统根据相关条件，创建优惠券
     *
     *  @param  couponBo       优惠券信息
     *  @param  userBo         调用方法的用户的信息
     *
     *  @return 优惠券实体 CouponBo 
     */
    CouponBo createCoupon(CouponBo couponBo, UserBo userBo);

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
    List<CouponBo> query(CouponBo couponBo, UserBo userBo,PaginationBo paginationBo);

    /**
     *  本方法为查询优惠券历史功能。<br>
     *  用户可以查询自己拥有的优惠券历史，系统可以查看所有优惠券历史
     *
     *  @param  couponHistoryBo        需要检索和过滤的优惠券历史
     *  @param  userBo          调用方法的用户的信息
     *  @param  paginationBo    分页信息
     *
     *  @return CouponHistoryBo 列表
     *
     */ 
    List<CouponBo> queryHistory(CouponHistoryBo couponHistoryBo,UserBo userBo, PaginationBo paginationBo);

}
