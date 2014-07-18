include "model/fault.thrift"
include "model/common.thrift"
include "model/account.thrift"
include "model/accountHistory.thrift"
include "model/user.thrift"


namespace java com.ishangke.edunav.commoncontract.service

service AccountService{

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
    account.AccountBo exchangeCash(1: account.AccountBo accountBo, 2: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
    list<account.AccountBo> query(1: account.AccountBo accountBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
     list<accountHistory.AccountHistoryBo> queryHistory(1: accountHistory.AccountHistoryBo accountHistoryBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

}