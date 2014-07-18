namespace java com.ishangke.edunav.commoncontract.model

/**
 * UserBo
 */
struct UserBo {
    1: i32 id
    2: string name
    3: string password
    4: string phone
    5: string wechat
    6: string email
    7: string avatarUrl
    8: string invitationCode
    9: string appliedInvitationCode
    10: string reference
    11: i64 lastLoginTime
    12: i64 lastModifyTime
    13: i64 createTime
    14: i32 enabled
    15: i32 gender
    16: i64 birthday
    17: string school
    18: string major
    19: set<i32> idSet
    20: i64 lastModifyTimeStart
    21: i64 lastModifyTimeEnd
    22: i64 createTimeStart
    23: i64 createTimeEnd
    24: i64 lastLoginTimeStart
    25: i64 lastLoginTimeEnd
    26: i64 birthdayStart
    27: i64 birthdayEnd
}
    
/**
 * LoginBo
 * note different users have diferent account identifiers, eg, user logs in with phone, admin may login with reference
 */
struct LoginBo {
  1: i32 id
  2: string accountIdentifier
  3: string password
}

/**
 *	SessionBo
 *  note different users have diferent account identifiers, eg, user logs in with phone, admin may login with reference
 */
struct SessionBo {
  1: i32 id
  2: string accountIdentifier
  3: string authCode
}