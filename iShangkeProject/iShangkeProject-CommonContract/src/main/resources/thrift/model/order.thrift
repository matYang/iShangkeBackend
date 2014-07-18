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
    7: string status
    8: i32 enabled
    9: set<i32> idSet
    10: set<i32> bookingIdSet
    11: i64 createTimeStart
    12: i64 createTimeEnd
    13: double priceStart
    14: double priceEnd
}

/**
 * CommentOrderCreateBo
 */
struct CommentOrderCreateBo {
  1: i32 id
  2: string comment
}

/**
 * CommentOrderAcceptBo
 */
struct CommentOrderAcceptBo {
  1: i32 id
  2: string comment
}

/**
 * CommentOrderAcceptSuccessBo
 */
struct CommentOrderAcceptSuccessBo {
  1: i32 id
  2: string comment
}

/**
 * CommentOrderAcceptFailedBo
 */
struct CommentOrderAcceptFailedBo {
  1: i32 id
  2: string comment
}

/**
 * CommentOrderValidateBo
 */
struct CommentOrderValidateBo {
  1: i32 id
  2: string comment
}

/**
 * CommentOrderCancelBo
 */
struct CommentOrderCancelBo {
  1: i32 id
  2: string comment
}