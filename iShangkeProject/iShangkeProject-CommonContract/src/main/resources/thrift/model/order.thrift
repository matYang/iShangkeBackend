namespace java com.ishangke.edunav.commoncontract.model

/**
 * OrderBo
 */
struct OrderBo {
    1: i32 id
    2: i32 bookingId
    3: i64 createTime
    4: string type
    5: double price
    6: string runingNumber
    7: i32 status
    8: i32 enabled
    9: set<i32> idSet
    10: set<i32> bookingIdSet
    11: set<i32> statusSet
    12: i64 createTimeStart
    13: i64 createTimeEnd
    14: double priceStart
    15: double priceEnd
    16: string reference
    17: string sign
    18: i64 confirmedTime
    19: i64 confirmedTimeStart
    20: i64 confirmedTimeEnd
    
}

/**
 * CommentOrderBo
 */
struct CommentOrderBo {
  1: i32 id
  2: string comment
}