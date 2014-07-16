namespace java com.ishangke.edunav.commoncontract.model

struct UserLocation {
    1: i32 id
    2: i32 userId
    3: i32 locationId
    4: i64 lastModifyTime
    5: i32 deleted
    6: i32 idStart
    7: i32 idEnd
    8: set<i32> idSet
    9: i64 lastModifyTimeStart
    10: i64 lastModifyTimeEnd
}