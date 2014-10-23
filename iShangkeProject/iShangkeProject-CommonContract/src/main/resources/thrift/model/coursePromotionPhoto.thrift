namespace java com.ishangke.edunav.commoncontract.model

struct CoursePromotionPhotoBo {
  1: i32 id
  2: i32 coursePromotionId
  3: string url
  4: i32 type
}

struct CoursePromotionPhotoPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<CoursePromotionPhotoBo> data
}