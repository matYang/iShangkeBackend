namespace java com.ishangke.edunav.commoncontract.model

struct CouponHistoryBo {
    1: i32 id
    2: i32 couponId
    3: double charge
    4: i64 lastModifyTime
    5: i64 createTime
    6: set<i32> idSet
    7: set<i32> couponIdSet
    8: double chargeStart
    9: double chargeEnd
    10: i64 lastModifyTimeStart
    11: i64 lastModifyTimeEnd
    12: i64 createTimeStart
    13: i64 createTimeEnd
}
struct CouponHistoryBoPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<CouponHistoryBo> data
} 