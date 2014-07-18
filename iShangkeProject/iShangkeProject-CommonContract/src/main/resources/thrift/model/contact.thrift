namespace java com.ishangke.edunav.commoncontract.model

struct ContactBo {
    1: i32 id
    2: i32 userId
    3: string name
    4: string phone
    5: string email
    6: i64 lastModifyTime
    7: i64 createTime
    8: i32 enabled
    9: set<i32> idSet
    10: set<i32> userIdSet
    11: i64 lastModifyTimeStart
    12: i64 lastModifyTimeEnd
    13: i64 createTimeStart
    14: i64 createTimeEnd
}