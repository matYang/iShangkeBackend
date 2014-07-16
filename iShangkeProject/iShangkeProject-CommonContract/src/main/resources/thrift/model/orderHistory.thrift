namespace java com.ishangke.edunav.commoncontract.model

struct OrderHistoryBo {
    1: i32 id
    2: i32 orderId
    3: i32 userId
    4: i32 optName
    5: string remark
    6: i32 preStatus
    7: i32 postStatus
    8: i32 normal
    9: i64 createTime
    10: i32 enabled
    11: i32 deleted
    12: i32 idStart
    13: i32 idEnd
    14: set<i32> idSet
    15: i64 createTimeStart
    16: i64 createTimeEnd
}