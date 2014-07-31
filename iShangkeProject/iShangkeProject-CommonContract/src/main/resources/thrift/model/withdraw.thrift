namespace java com.ishangke.edunav.commoncontract.model

/**
 * WithdrawBo
 * 客户的付款/提现方式
 */
struct WithdrawBo {
    1: i32 id
    2: i32 userId
    3: string payeeId
    4: string payeeName
    5: i32 type
    6: i64 lastModifyTime
    7: i64 createTime
    8: i32 enabled
    9: set<i32> idSet
    10: set<i32> userIdSet
    11: set<i32> typeSet
    12: i64 lastModifyTimeStart
    13: i64 lastModifyTimeEnd
    14: i64 createTimeStart
    15: i64 createTimeEnd
}
struct WithdrawPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<WithdrawBo> data
} 