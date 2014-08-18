namespace java com.ishangke.edunav.commoncontract.model

struct CoursePromotionBo {
  1: i32 id
  2: i32 courseId
  3: i32 categoryId
  4: i64 createTime
  5: i64 startTime
  6: i64 endTime
  7: i32 status
  8: i64 createTimeStart
  9: i64 startTimeStart
  10: i64 endTimeStart 
  11: i64 createTimeEnd
  12: i64 startTimeEnd
  13: i64 endTimeEnd
}

struct CoursePromotionPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<CoursePromotionBo> data
} 