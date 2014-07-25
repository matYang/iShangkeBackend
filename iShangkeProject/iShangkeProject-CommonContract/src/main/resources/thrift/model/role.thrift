namespace java com.ishangke.edunav.commoncontract.model

struct RoleBo {
    1: i32 id
    2: string name
    3: i64 lastModifyTime
    4: i64 createTime
    5: i32 enabled
    6: set<i32> idSet
    7: i64 createTimeStart
    8: i64 createTimeEnd
    9: i64 lastModifyTimeStart
    10: i64 lastModifyTimeEnd
}
struct RoleBoPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<RoleBo> data
} 