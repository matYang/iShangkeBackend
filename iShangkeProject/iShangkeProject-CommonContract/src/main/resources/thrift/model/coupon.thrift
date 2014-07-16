namespace java com.ishangke.edunav.commoncontract.model

/**
 * CouponBo
 */
struct CouponBo {
    1: i32 id
    2: string code
    3: double total
    4: double balance
    5: i64 expiryTime
    6: string remark
    7: i32 userId
    8: i64 lastModifyTime
    9: i64 createTime
    10: i32 enabled
    11: i32 deleted
    12: i32 idStart
    13: i32 idEnd
    14: double totalStart
    15: double totalEnd
    16: double balanceStart
    17: double balanceEnd
    18: i64 expiryTimeStart
    19: i64 expiryTimeEnd
    20: i32 userIdStart
    21: i32 userIdEnd
    22: i64 lastModifyTimeStart
    23: i64 lastModifyTimeEnd
    24: i64 createTimeStart
    25: i64 createTimeEnd
}