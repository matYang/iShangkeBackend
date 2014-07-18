namespace java com.ishangke.edunav.commoncontract.model

struct MessageBo {
    1: i32 id
    2: string messageText
    3: i32 userFromId
    4: i32 userToId
    5: i64 createTime
    6: set<i32> idSet
    7: i64 createTimeStart
    8: i64 createTimeEnd
}

