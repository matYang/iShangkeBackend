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
    9: i32 deleted
    10: i32 idStart
    11: i32 idEnd
    12: set<i32> idSet
    13: i64 createTimeStart
    14: i64 createTimeEnd
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