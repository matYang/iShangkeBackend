include "groupBuyActivity.thrift"
include "user.thrift"
namespace java com.ishangke.edunav.commoncontract.model

struct GroupBuyBookingBo {
  1: i32 id
  2: i64 createTime
  3: i32 status
  4: double groupBuyPrice
  5: i32 groupBuyActivityId
  6: i32 userId
  7: groupBuyActivity.GroupBuyActivityBo groupBuyActivity
  8: user.UserBo user
  9: set<i32> idSet
  10: i64 createTimeStart
  11: i64 createTimeEnd
  12: set<i32> statusSet
  13: double groupBuyPriceStart
  14: double groupBuyPriceEnd
  15: set<i32> groupBuyActivityIdSet
  16: set<i32> userIdSet
  17: string reference
  18: string number
}

struct GroupBuyBookingPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4:list<GroupBuyBookingBo> data
} 