include "course.thrift"
include "groupBuyPhoto.thrift"
namespace java com.ishangke.edunav.commoncontract.model

struct GroupBuyActivityBo {
  1: i32 id
  2: i64 createTime
  3: i64 endTime
  4: i32 status
  5: i32 courseId
  6: course.CourseBo course
  7: set<i32> idSet
  8: i64 createTimeStart
  9: i64 createTimeEnd
  10: set<i32> statusSet
  11: set<i32> courseIdSet
  12: double groupBuyPrice
  13: double groupBuyPriceStart
  14: double groupBuyPriceEnd
  15: i64 endTimeStart
  16: i64 endTimeEnd
  17: list<groupBuyPhoto.GroupBuyPhotoBo> photoList;
}

struct GroupBuyActivityPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<GroupBuyActivityBo> data
} 