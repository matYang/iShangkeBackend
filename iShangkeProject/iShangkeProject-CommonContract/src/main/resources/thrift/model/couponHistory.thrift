namespace java com.ishangke.edunav.commoncontract.model

struct CouponHistoryBo {
    1: i32 id
    2: i32 couponId
    3: double charge
    4: i64 lastModifyTime
    5: i64 createTime
    6: i32 deleted
    7: i32 idStart
    8: i32 idEnd
    9: set<i32> idSet
    10: i64 lastModifyTimeStart
    11: i64 lastModifyTimeEnd
    12: i64 createTimeStart
    13: i64 createTimeEnd
}