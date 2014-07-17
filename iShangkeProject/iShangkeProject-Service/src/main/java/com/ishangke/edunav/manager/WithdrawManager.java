package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.commoncontract.model.WithdrawBo;

public interface WithdrawManager {

    /**
     * 创建存取款信息。<br>
     * 用户可以创建存取款信息
     * 
     * @param withdrawBo
     *            需要创建的存取款信息
     * @param userBo
     *            发起创建的用户信息
     * 
     * @return 创建完成的存取款信息
     * 
     * 
     * @param withdrawBo
     * @param userBo
     */
    public WithdrawBo createWithdraw(WithdrawBo withdrawBo, UserBo userBo);

    /**
     * 更新存取款信息。<br>
     * 用户可以更新存取款信息
     * 
     * @param withdrawBo
     *            需要更新的存取款信息
     * @param userBo
     *            发起更新的用户信息
     * 
     * @return 更新完成的存取款信息
     * 
     * 
     * @param withdrawBo
     * @param userBo
     */
    public WithdrawBo updateWithdraw(WithdrawBo withdrawBo, UserBo userBo);

    /**
     * 删除存取款信息。<br>
     * 用户可以删除存取款信息
     * 
     * @param withdrawBo
     *            需要删除的存取款信息
     * @param userBo
     *            发起删除的用户信息
     * 
     * @return
     * 
     * 
     * @param withdrawBo
     * @param userBo
     */
    public WithdrawBo deleteWithdraw(WithdrawBo withdrawBo, UserBo userBo);

    /**
     * 查询存取款信息。<br>
     * 用户可以查询存取款信息
     * 
     * @param withdrawBo
     *            需要查询的存取款信息
     * @param userBo
     *            发起查询的用户信息
     * @param paginationBo
     *            分页信息
     * 
     * @return Withdraw 列表
     * 
     * 
     * @param withdrawBo
     * @param userBo
     * @param paginationBo
     */
    public List<WithdrawBo> query(WithdrawBo withdrawBo, UserBo userBo, PaginationBo paginationBo);

}
