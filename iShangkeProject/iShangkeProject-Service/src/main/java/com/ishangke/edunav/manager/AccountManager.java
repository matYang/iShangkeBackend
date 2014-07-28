package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.AccountBo;
import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface AccountManager {
    /**
     * 本方法为账户提现功能。<br>
     * 用户可以将自己账户中的现金提现
     * 
     * @param accountBo
     *            需要提现的账户信息
     * @param userBo
     *            调用方法的用户的信息
     * @param amount
     *            需要提取的现金
     * @param withdraw
     *            取款方式
     *                 
     * @return
     * 
     */
    AccountBo exchangeCash(AccountBo accountBo, UserBo userBo, Double amount, String payee_Id, String payee_Name, int type);

    /**
     * 本方法为查询账户功能。<br>
     * 用户可以查询自己拥有的账户，系统可以查看所有账户
     * 
     * @param accountBo
     *            需要检索和过滤的账户信息
     * @param userBo
     *            调用方法的用户的信息
     * @param paginationBo
     *            分页信息
     * 
     * @return AccountBo 列表
     * 
     */
    List<AccountBo> query(AccountBo accountBo, UserBo userBo, PaginationBo paginationBo);

    /**
     * 本方法为查询账户历史功能。<br>
     * 用户可以查询自己拥有的账户的历史信息，系统可以查看所有账户的历史信息
     * 
     * @param accountBo
     *            需要检索和过滤的账户信息
     * @param userBo
     *            调用方法的用户的信息
     * @param paginationBo
     *            分页信息
     * 
     * @return AccountHistoryBo 列表
     * 
     */
    List<AccountHistoryBo> queryHistory(AccountHistoryBo accountHistoryBo, UserBo userBo, PaginationBo paginationBo);

}
