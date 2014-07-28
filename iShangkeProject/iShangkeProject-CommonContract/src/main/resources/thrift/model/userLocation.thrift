namespace java com.ishangke.edunav.commoncontract.model

struct UserLocationBo {
    1: i32 id
    2: i32 userId
    3: i32 locationId
    4: i64 lastModifyTime
    5: set<i32> idSet
    6: i64 lastModifyTimeStart
    7: i64 lastModifyTimeEnd
    8: i64 createTimeStart
    9: i64 createTimeEnd
    10: i64 lastLoginTimeStart
    11: i64 lastLoginTimeEnd
    12: i64 birthdayStart
    13: i64 birthdayEnd
    14: set<i32> userIdSet
    15: set<i32> locationIdSet
}
struct UserLocationPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<UserLocationBo> data
} 