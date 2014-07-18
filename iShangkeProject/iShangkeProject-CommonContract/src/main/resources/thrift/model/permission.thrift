namespace java com.ishangke.edunav.commoncontract.model

struct PermissionBo {
    1: i32 id
    2: string name
    3: string path
    4: string tag
    5: i64 lastModifyTime
    6: i64 createTime
    7: i32 enabled
    8: set<i32> idSet
    9: i64 lastModifyTimeStart
    10: i64 lastModifyTimeEnd
    11: i64 createTimeStart
    12: i64 createTimeEnd
}