namespace java com.ishangke.edunav.commoncontract.model

/**
 * UserBo
 */
struct UserBo {
  1: i32 id
  2: string name
  3: string password
}

/**
 * LoginBo
 */
struct LoginBo {
  1: i32 id
  2: string phone
  3: string password
}

/**
 *
 */
struct SessionBo {
  1: i32 id
  2: string phone
  3: authCode
}