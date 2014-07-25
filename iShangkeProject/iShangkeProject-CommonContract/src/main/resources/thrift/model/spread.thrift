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
    11: set<i32> idSet
    12: set<i32> userIdSet
    13: set<i32> partnerIdSet
    14: set<i32> courseIdSet
    15: set<i32> statusSet
    16: i64 lastModifyTimeStart
    17: i64 lastModifyTimeEnd
    18: i64 createTimeStart
    19: i64 createTimeEnd

}
struct SpreadBoPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<SpreadBo> data
} 