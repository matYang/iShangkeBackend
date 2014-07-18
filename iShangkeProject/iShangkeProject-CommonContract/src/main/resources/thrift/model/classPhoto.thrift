namespace java com.ishangke.edunav.commoncontract.model

struct ClassPhotoBo {
    1: i32 id
    2: i32 courseId
    3: i32 classPhotoId
    4: i64 createTime
    5: set<i32> idSet
    6: set<i32> partnerIdSet
    7: i64 lastModifyTimeStart
    8: i64 lastModifyTimeEnd
    9: i64 createTimeStart
    10: i64 createTimeEnd
}