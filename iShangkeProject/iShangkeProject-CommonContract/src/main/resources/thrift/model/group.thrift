namespace java com.ishangke.edunav.commoncontract.model

struct GroupBo {
    1: i32 id
    2: string name
    3: i32 roleId
    4: i64 lastModifyTime
    5: i64 createTime
    6: i32 enabled   
    7: i32 partnerId
    8: set<i32> idSet
    9: set<i32> roleIdSet
    10: set<i32> partnerIdSet
    11: i64 lastModifyTimeStart
    12: i64 lastModifyTimeEnd
    13: i64 createTimeStart
    14: i64 createTimeEnd
}