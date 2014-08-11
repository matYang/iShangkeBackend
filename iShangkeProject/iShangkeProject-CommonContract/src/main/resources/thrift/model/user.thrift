include "account.thrift"
include "credit.thrift"
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
    28: i32 careerId
    29: i32 schoolId
    30: i32 locationId
    31: set<i32> careerIdSet
    32: set<i32> schoolIdSet
    34: set<i32> locationIdSet
    35: string authCode
    36: account.AccountBo account
    37: credit.CreditBo credit
    38: double couponTotal
    39: i32 majorId
    40: set<i32> majorIdSet
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

struct PasswordBo {
  1: i32 id
  2: string accountIdentifier
  3: string authCode
  4: string newPassword
  5: string oldPassword
}


struct UserPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<UserBo> data
} 

