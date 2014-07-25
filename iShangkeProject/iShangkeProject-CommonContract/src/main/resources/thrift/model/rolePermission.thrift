namespace java com.ishangke.edunav.commoncontract.model

struct RolePermissionBo {
    1: i32 id
    2: i32 roleId
    3: i32 permissionId
    4: i64 lastModifyTime
    5: set<i32> idSet
    6: set<i32> roleIdSet
    7: set<i32> permissionIdSet
    8: i64 lastModifyTimeStart
    9: i64 lastModifyTimeEnd
}
struct RolePermissionBoPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<RolePermissionBo> data
} 