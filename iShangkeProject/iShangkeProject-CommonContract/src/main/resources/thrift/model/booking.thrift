namespace java com.ishangke.edunav.commoncontract.model
include "action.thrift"

/**
 * BookingBo
 */
struct BookingBo {
    1: i32 id
    2: i32 userId
    3: i32 courseId
    4: i32 courseTemplateId
    5: string reference
    6: string name
    7: string phone
    8: string email
    9: i32 status
    10: i64 scheduledTime
    11: i64 noRefundDate
    12: i64 cashbackDate
    13: i32 type
    14: string note
    15: double cashbackAmount
    16: i64 lastModifyTime
    17: i64 createTime
    18: i32 enabled
    19: set<i32> idSet
    20: set<i32> courseIdSet
    21: set<i32> courseTemplateIdSet
    22: set<i32> userIdSet
    23: set<i32> statusSet
    24: i64 scheduledTimeStart
    25: i64 scheduledTimeEnd
    26: i64 noRefundDateStart
    27: i64 noRefundDateEnd
    28: i64 cashbackDateStart
    29: i64 cashbackDateEnd
    30: set<i32> typeSet
    31: double cashbackAmountStart
    32: double cashbackAmountEnd
    33: i64 lastModifyTimeStart
    34: i64 lastModifyTimeEnd
    35: i64 createTimeStart
    36: i64 createTimeEnd
    37: list<action.ActionBo> actionList
    38: double price
    39: double priceStart
    40: double priceEnd
    41: i32 partnerId
    42: set<i32> partnerIdSet
}

/**
 * CommentBookingBo
 */
struct CommentBookingBo {
  1: string comment
}
  struct BookingPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<BookingBo> data
} 
