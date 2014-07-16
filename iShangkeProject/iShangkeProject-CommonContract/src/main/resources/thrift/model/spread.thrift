namespace java com.ishangke.edunav.commoncontract.model

struct SpreadBo {
    1: i32 id
    2: i32 userId
    3: i32 partnerId
    4: i32 courseId
    5: string url
    6: string remark
    7: i32 status
    8: i64 lastModifyTime
    9: i64 createTime
    10: i32 enabled
    11: i32 deleted
    12: i32 idStart
    13: i32 idEnd
    14: set<i32> idSet
    15: i64 lastModifyTimeStart
    16: i64 lastModifyTimeEnd
    17: i64 createTimeStart
    18: i64 createTimeEnd
}