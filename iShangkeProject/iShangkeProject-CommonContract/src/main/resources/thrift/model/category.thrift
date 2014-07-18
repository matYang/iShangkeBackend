namespace java com.ishangke.edunav.commoncontract.model

struct CategoryBo {
    1: i32 id
    2: string value
    3: string name
    4: i32 rank
    5: i64 lastModifyTime
    6: i64 createTime
    7: i32 enabled
    8: set<i32> idSet
    9: i32 rankStart
    10: i32 rankEnd
    11: set<i32> rankSet
    12: i64 lastModifyTimeStart
    13: i64 lastModifyTimeEnd
    14: i64 createTimeStart
    15: i64 createTimeEnd
   }