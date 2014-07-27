namespace java com.ishangke.edunav.commoncontract.model

struct CourseCommentBo {
    1: i32 id
    2: i32 userId
    3: i32 courseTemplateId
    4: string title
    5: string content
    6: double totalRating
    7: double conditionRating
    8: double attitudeRating
    9: double satisfactionRating
    10: i64 lastModifyTime
    11: i64 createTime
    12: i32 enabled
    13: set<i32> idSet
    14: set<i32> userIdSet
    15: set<i32> courseTemplateIdSet
    16: double totalRatingStart
    17: double totalRatingEnd
    18: double conditionRatingStart
    19: double conditionRatingEnd
    20: double attitudeRatingStart
    21: double attitudeRatingEnd
    22: double satisfactionRatingStart
    23: double satisfactionRatingEnd
    24: i64 lastModifyTimeStart
    25: i64 lastModifyTimeEnd
    26: i64 createTimeStart
    27: i64 createTimeEnd
}

struct CourseCommentBoPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<CourseCommentBo> data
} 