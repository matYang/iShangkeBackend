namespace java com.ishangke.edunav.commoncontract.model

struct GroupBuyAddressBo {
  1: i32 id
  2: i32 groupBuyActivityId
  3: i32 addressId
}

struct GroupBuyAddressPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<GroupBuyAddressBo> data
}