namespace java com.ishangke.edunav.commoncontract.model

struct AccountHistoryBo {
    1: i32 id
    2: i32 userId
    3: i32 withdrawId
    4: double charge
    5: i32 type
    6: i64 createTime
    7: string remark
    8: set<i32> idSet
    9: set<i32> userIdSet
    10: set<i32> withdrawIdSet
    11: double chargeStart
    12: double chargeEnd
    13: set<i32> typeSet
    14: i64 createTimeStart
    15: i64 createTimeEnd
}

struct AccountHistoryPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<AccountHistoryBo> data
}