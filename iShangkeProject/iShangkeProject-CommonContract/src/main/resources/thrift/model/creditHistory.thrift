namespace java com.ishangke.edunav.commoncontract.model

struct CreditHistoryBo {
    1: i32 id
    2: double charge
    3: i32 userId
    4: i64 lastModifyTime
    5: i64 createTime
    6: set<i32> idSet
    7: double chargeStart
    8: double chargeEnd
    9: set<i32> userIdSet
    10: i64 lastModifyTimeStart
    11: i64 lastModifyTimeEnd
    12: i64 createTimeStart
    13: i64 createTimeEnd
    14: i32 operation
    15: set<i32> operationSet
}
struct CreditHistoryPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<CreditHistoryBo> data
} 