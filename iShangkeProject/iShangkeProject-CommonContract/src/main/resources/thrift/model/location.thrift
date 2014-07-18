namespace java com.ishangke.edunav.commoncontract.model

struct LocationBo {
    1: i32 id
    2: string value
    3: string name
    4: i64 lastModifyTime
    5: i64 createTime
    6: i32 enabled
    7: set<i32> idSet
    8: i64 lastModifyTimeStart
    9: i64 lastModifyTimeEnd
    10: i64 createTimeStart
    11: i64 createTimeEnd
}

