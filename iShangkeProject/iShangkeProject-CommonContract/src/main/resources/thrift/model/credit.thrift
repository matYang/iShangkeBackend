namespace java com.ishangke.edunav.commoncontract.model

struct CreditBo {
    1: i32 id
    2: double credit
    3: i64 lastModifyTime
    4: i64 createTime
    5: i32 enabled
    6: set<i32> idSet
    7: double creditStart
    8: double creditEnd
    9: i64 lastModifyTimeStart
    10: i64 lastModifyTimeEnd
    11: i64 createTimeStart
    12: i64 createTimeEnd
}
struct CreditBoPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<CreditBo> data
} 