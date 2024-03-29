package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.commoncontract.model.CreditBo;
import com.ishangke.edunav.commoncontract.model.CreditHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface CreditManager {

    /**
     * 本方法为换取优惠券。<br>
     * 用户可以将自己的积分换取优惠券
     * 
     * @param creditBo
     *            积分信息
     * @param couponBo
     *            优惠券信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param creditBo
     * @param couponBo
     * @param userBo
     */
    CreditBo modifyCredit(CreditBo creditBo, UserBo userBo);

    /**
     * 本方法为换取优惠券。<br>
     * 用户可以将自己的积分换取优惠券
     * 
     * @param creditBo
     *            积分信息
     * @param couponBo
     *            优惠券信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param creditBo
     * @param couponBo
     * @param userBo
     */
    CreditBo exchangeCoupon(CreditBo creditBo, CouponBo couponBo, UserBo userBo);

    /**
     * 本方法为换取现金。<br>
     * 用户可以将自己的积分换取现金
     * 
     * @param creditBo
     *            积分信息
     * @param accountBo
     *            账户信息信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param creditBo
     * @param accountBo
     * @param userBo
     */
    CreditBo exchangeAccount(CreditBo creditBo, AccountBo accountBo, UserBo userBo);

    /**
     * 本方法为查询积分功能。<br>
     * 用户可以查询自己拥有的积分，系统可以查看所有积分
     * 
     * @param creditBo
     *            需要检索和过滤的积分信息
     * @param userBo
     *            调用方法的用户的信息
     * @param paginationBo
     *            分页信息
     * 
     * @return 积分实体 CreditBo 列表
     * 
     * 
     * @param creditBo
     * @param userBo
     * @param paginationBo
     */
    List<CreditBo> query(CreditBo creditBo, UserBo userBo, PaginationBo paginationBo);
    int queryTotal(CreditBo creditBo, UserBo userBo);
    /**
     * 本方法为查询积分历史功能。<br>
     * 用户可以查询自己的使用积分历史，系统可以查看所有积分历史
     * 
     * @param creditHistoryBo
     *            需要检索和过滤的积分信息历史
     * @param userBo
     *            调用方法的用户的信息
     * @param paginationBo
     *            分页信息
     * 
     * @return 积分实体 CreditBo 列表
     * 
     * 
     * @param creditHistoryBo
     * @param userBo
     * @param paginationBo
     */
    List<CreditHistoryBo> queryHistory(CreditHistoryBo creditHistoryBo, UserBo userBo, PaginationBo paginationBo);
    int queryHistoryTotal(CreditHistoryBo creditHistoryBo, UserBo userBo);
}
