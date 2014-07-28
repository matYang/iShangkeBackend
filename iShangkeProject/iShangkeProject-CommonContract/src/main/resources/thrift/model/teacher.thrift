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
    10: set<i32> idSet
    11: set<i32> partnerIdSet
    12: i32 popularityStart
    13: i32 popularityEnd
    14: set<i32> popularitySet
    15: i64 lastModifyTimeStart
    16: i64 lastModifyTimeEnd
    17: i64 createTimeStart
    18: i64 createTimeEnd

}
struct TeacherPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<TeacherBo> data
} 

