namespace java com.ishangke.edunav.commoncontract.model

/**
 * OrderBo
 */
struct OrderBo {
  1: i32 id
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