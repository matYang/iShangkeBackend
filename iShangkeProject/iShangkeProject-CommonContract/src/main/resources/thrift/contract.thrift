namespace java com.ishangke.edunav.commoncontract.model

struct ContractBo {
    1: i32 id
    2: i32 userId
    3: string name
    4: string phone
    5: string email
    6: i64 lastModifyTime
    7: i64 createTime
    8: i32 deleted
    9: i32 enabled
    10: i32 idStart
    11: i32 idEnd
    12: set<i32> idSet
    13: i32 userIdStart
    14: i32 userIdEnd
    15: set<i32> userIdSet
    16: i64 lastModifyTimeStart
    17: i64 lastModifyTimeEnd
    18: i64 createTimeStart
    19: i64 createTimeEnd
}