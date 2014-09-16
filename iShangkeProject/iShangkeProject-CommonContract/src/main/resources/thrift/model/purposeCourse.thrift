namespace java com.ishangke.edunav.commoncontract.model

struct PurposeCourseBo {
  1: i32 id
  2: i32 categoryId
  3: string userName
  4: string phone
  5: string remark
  6: i64 createTime
  7: i64 createTimeStart
  8: i64 createTimeEnd
}

struct PurposeCoursePageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<PurposeCourseBo> data
} 