namespace java com.ishangke.edunav.commoncontract.model

struct GroupBuyPhotoBo {
  1: i32 id
  2: i32 groupBuyActivityId
  3: string url
  4: i32 deleted
}

struct GroupBuyPhotoPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<GroupBuyPhotoBo> data
}