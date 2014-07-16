namespace java com.ishangke.edunav.commoncontract.model

struct PermissionBo {
    1: i32 id
    2: string name
    3: string path
    4: i64 lastModifyTime
    5: i64 createTime
    6: i32 enabled
    7: i32 deleted
    8: i32 idStart
    9: i32 idEnd
    10: set<i32> idSet
    11: i64 lastModifyTimeStart
    12: i64 lastModifyTimeEnd
    13: i64 createTimeStart
    14: i64 createTimeEnd
}