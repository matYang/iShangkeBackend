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
    11: set<i32> idSet
    12: set<i32> bookingIdSet
    13: set<i32> userIdSet
    14: set<i32> optNameSet
    15: set<i32> preStatusSet
    16: set<i32> postStatusSet
    17: set<i32> normalSet
    18: i64 createTimeStart
    19: i64 createTimeEnd
    }