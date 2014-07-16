namespace java com.ishangke.edunav.commoncontract.model

struct BookingHistoryBo {
    1: i32 id
    2: i32 bookingId
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
    15: i32 bookingIdStart
    16: i32 bookingIdEnd
    17: set<i32> bookingIdSet
    18: i32 userIdStart
    19: i32 userIdEnd
    20: set<i32> userIdSet
    21: i64 createTimeStart
    22: i64 createTimeEnd
}