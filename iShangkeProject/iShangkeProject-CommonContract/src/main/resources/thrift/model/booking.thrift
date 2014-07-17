namespace java com.ishangke.edunav.commoncontract.model

/**
 * BookingBo
 */
struct BookingBo {
  1: i32 id
}

/**
 * CommentBookingCreateBo
 */
struct CommentBookingCreateBo {
  1: i32 id
  2: string comment
}

/**
 * CommentBookingAcceptBo
 */
struct CommentBookingAcceptBo {
  1: i32 id
  2: string comment
}

/**
 * CommentBookingAcceptSuccessBo
 */
struct CommentBookingAcceptSuccessBo {
  1: i32 id
  2: string comment
}

/**
 * CommentBookingAcceptFailedBo
 */
struct CommentBookingAcceptFailedBo {
  1: i32 id
  2: string comment
}

/**
 * CommentBookingValidateBo
 */
struct CommentBookingValidateBo {
  1: i32 id
  2: string comment
}

/**
 * CommentBookingCancelBo
 */
struct CommentBookingCancelBo {
  1: i32 id
  2: string comment
}

