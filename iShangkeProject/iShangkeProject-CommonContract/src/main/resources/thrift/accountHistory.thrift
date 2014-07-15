namespace java com.ishangke.edunav.commoncontract.model

struct AccountHistoryBo {
    1: i32 id
    2: i32 userId
    3: i32 withdrawId
    4: double charge
    5: i32 type
    6: i64 createTime
    7: string remark
    8: i32 deleted
    9: i32 idStart
    10: i32 idEnd
    11: i32 idSet
    12: i32 userIdStart
    13: i32 userIdEnd
    14: i32 withdrawIdStart
    15: i32 withdrawIdEnd
    16: double chargeStart
    17: double chargeEnd
    18: i32 typeStart
    19: i32 typeEnd
    20: i64 createTimeStart
    21: i64 createTimeEnd
}