namespace java com.ishangke.edunav.commoncontract.model

/**
 * CouponBo
 */
struct CouponBo {
    1: i32 id
    2: string code
    3: double total
    4: double balance
    5: i32 origin
    6: i64 expiryTime
    7: string remark
    8: i32 userId
    9: i64 lastModifyTime
    10: i64 createTime
    11: i32 enabled
    12: set<i32> idSet
    13: double totalStart
    14: double totalEnd
    15: double balanceStart
    16: double balanceEnd
    17: i64 expiryTimeStart
    18: i64 expiryTimeEnd
    19: set<i32> userIdSet
    20: i64 lastModifyTimeStart
    21: i64 lastModifyTimeEnd
    22: i64 createTimeStart
    23: i64 createTimeEnd
    24: set<i32> originSet
    25: i32 status
    26: set<i32> statusSet
}
struct CouponBoPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<CouponBo> data
} 