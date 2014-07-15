namespace java com.ishangke.edunav.commoncontract.model

/**
 * TeacherBo
 */
struct TeacherBo {
    1: i32 id
    2: i32 partnerId
    3: string imgUrl
    4: string name
    5: string intro
    6: i32 popularity
    7: i64 lastModifyTime
    8: i64 createTime
    9: i32 enabled
    10: i32 deleted
    11: i32 idStart
    12: i32 idEnd
    13: set<i32> idSet
    14: i32 partnerIdStart
    15: i32 partnerIdEnd
    16: set<i32> partnerIdSet
    17: i32 popularityStart
    18: i32 popularityEnd
    19: i64 lastModifyTimeStart
    20: i64 lastModifyTimeEnd
    21: i64 createTimeStart
    22: i64 createTimeEnd
}

