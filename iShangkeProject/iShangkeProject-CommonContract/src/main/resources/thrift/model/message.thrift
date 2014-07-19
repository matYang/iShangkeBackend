namespace java com.ishangke.edunav.commoncontract.model

struct MessageBo {
    1: i32 id
    2: string messageText
    3: i32 userFromId
    4: i32 userToId
    5: i32 status
    6: i64 readTime
    7: i64 createTime
    8: set<i32> idSet
    9: set<i32> userFromIdSet
    10: set<i32> userToIdSet
    11: set<i32> statusSet
    12: i64 readTimeStart
    13: i64 readTimeEnd
    14: i64 createTimeStart
    15: i64 createTimeEnd
}

