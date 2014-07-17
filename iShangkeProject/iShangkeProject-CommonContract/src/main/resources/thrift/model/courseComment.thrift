namespace java com.ishangke.edunav.commoncontract.model

struct CourseCommentBo {
    1: i32 id
    2: i32 userId
    3: i32 courseTemplateId
    4: string title
    5: string content
    6: i64 lastModifyTime
    7: i64 createTime
    8: i32 enabled
    9: i32 deleted
    10: i32 idStart
    11: i32 idEnd
    12: set<i32> idSet
    13: i64 lastModifyTimeStart
    14: i64 lastModifyTimeEnd
    15: i64 createTimeStart
    16: i64 createTimeEnd
}