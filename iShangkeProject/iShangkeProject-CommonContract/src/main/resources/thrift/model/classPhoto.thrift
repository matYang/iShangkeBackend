namespace java com.ishangke.edunav.commoncontract.model

struct ClassPhotoBo {
    1: i32 id
    2: i32 partnerId
    3: string imgUrl
    4: string title
    5: string description
    6: i64 lastModifyTime
    7: i64 createTime
    8: i32 enabled
    9: set<i32> idSet
    10: set<i32> partnerIdSet
    11: i64 lastModifyTimeStart
    12: i64 lastModifyTimeEnd
    13: i64 createTimeStart
    14: i64 createTimeEnd
    15: string snapshotUrl
}
struct ClassPhotoBoPageViewBo{
    1: i32 start
    2: i32 count
    3: i32 total
    4: list<ClassPhotoBo> data
} 