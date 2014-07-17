namespace java com.ishangke.edunav.commoncontract.model

/**
 * ResponseBo
 */
struct ResponseBo {
  1: i32 status
  2: string messageKey
}

/**
 * OrderByBo
 */
struct OrderByBo {
  1: string columnKey
  2: string order
}

/**
 * PaginationBo
 */
struct PaginationBo {
  1: i32 size
  2: i32 offset
  3: list<OrderByBo> orderByEntities
}
