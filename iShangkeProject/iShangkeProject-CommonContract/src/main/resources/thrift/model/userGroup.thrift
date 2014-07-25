namespace java com.ishangke.edunav.commoncontract.model

struct UserGroupBo {
    1: i32 id
    2: i32 userId
    3: i32 groupId
    4: i64 lastModifyTime
    5: set<i32> idSet
    6: set<i32> userIdSet
    7: set<i32> groupIdSet
    8: i64 lastModifyTimeStart
    9: i64 lastModifyTimeEnd
}
struct UserGroupBoPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<UserGroupBo> data
} 